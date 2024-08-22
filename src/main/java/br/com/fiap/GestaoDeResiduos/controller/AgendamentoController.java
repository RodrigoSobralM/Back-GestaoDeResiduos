package br.com.fiap.GestaoDeResiduos.controller;

import br.com.fiap.GestaoDeResiduos.model.Agendamento;
import br.com.fiap.GestaoDeResiduos.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Agendamento cadastrarAgendamento(@RequestBody Agendamento agendamento) {
        return agendamentoService.cadastrarAgendamento(agendamento);
    }

    @GetMapping("/buscar")
    @ResponseStatus(HttpStatus.OK)
    public List<Agendamento> buscarTodosAgendamentos() {
        return agendamentoService.buscarTodosAgendamentos();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Agendamento> buscarPorId(@PathVariable String id) {
        try {
            return ResponseEntity.ok(agendamentoService.buscarAgendamentoPorId(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAgendamento(@PathVariable String id) {
        agendamentoService.deletarAgendamentoPorId(id);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Agendamento> atualizarAgendamento(@RequestBody Agendamento agendamento) {
        try {
            Agendamento novoAgendamento = agendamentoService.atualizarAgendamento(agendamento);
            return ResponseEntity.ok(novoAgendamento);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
