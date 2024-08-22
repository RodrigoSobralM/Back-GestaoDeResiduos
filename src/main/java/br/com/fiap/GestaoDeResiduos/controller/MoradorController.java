package br.com.fiap.GestaoDeResiduos.controller;

import br.com.fiap.GestaoDeResiduos.model.Morador;
import br.com.fiap.GestaoDeResiduos.service.MoradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/morador")
public class MoradorController {

    @Autowired
    private MoradorService moradorService;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Morador cadastrarMorador(@RequestBody Morador morador) {
        return moradorService.cadastrarMorador(morador);
    }

    @GetMapping("/buscar")
    @ResponseStatus(HttpStatus.OK)
    public List<Morador> buscarTodosMoradores() {
        return moradorService.buscarTodosMoradores();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Morador> buscarMoradorPorId(@PathVariable String id) {
        try {
            return ResponseEntity.ok(moradorService.buscarMoradorPorId(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarMorador(@PathVariable String id) {
        moradorService.deletarMorador(id);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Morador> atualizarMorador(@RequestBody Morador morador) {
        try {
            Morador novoMorador = moradorService.atualizarMorador(morador);
            return ResponseEntity.ok(novoMorador);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
