package br.com.fiap.GestaoDeResiduos.controller;

import br.com.fiap.GestaoDeResiduos.model.Relatorio;
import br.com.fiap.GestaoDeResiduos.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relatorio")
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Relatorio cadastrarRelatorio(@RequestBody Relatorio relatorio) {
        return relatorioService.cadastarRealtorio(relatorio);
    }

    @GetMapping("/buscar")
    @ResponseStatus(HttpStatus.OK)
    public List<Relatorio> buscarTodosRelatorios() {
        return relatorioService.buscarTodosRelatorios();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Relatorio> buscarRelatorioPorId(@PathVariable String id) {
        try {
            return ResponseEntity.ok(relatorioService.buscarRelatorioPorId(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarRelatorio(@PathVariable String id) {
        relatorioService.deletarRelatorio(id);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Relatorio> atualizarRelatorio(@RequestBody Relatorio relatorio) {
        try {
            Relatorio novoRelatorio = relatorioService.atualizarRelatorio(relatorio);
            return ResponseEntity.ok(novoRelatorio);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
