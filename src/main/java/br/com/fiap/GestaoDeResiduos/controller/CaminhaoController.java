package br.com.fiap.GestaoDeResiduos.controller;

import br.com.fiap.GestaoDeResiduos.model.Caminhao;
import br.com.fiap.GestaoDeResiduos.service.CaminhaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caminhao")
public class CaminhaoController {

    @Autowired
    private CaminhaoService caminhaoService;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Caminhao cadastrarCamihao (@RequestBody Caminhao caminhao) {
        return caminhaoService.cadastrarCaminhao(caminhao);
    }

    @GetMapping("/buscar")
    @ResponseStatus(HttpStatus.OK)
    public List<Caminhao> buscarTodosCaminhoes() {
        return caminhaoService.buscarTodosCaminhoes();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Caminhao> buscarCaminhaoPorId(@PathVariable String id) {
        try {
            return ResponseEntity.ok(caminhaoService.buscarCaminhaoPorId(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCaminhao(@PathVariable String id) {
        caminhaoService.deletarCaminhaoPorId(id);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Caminhao> atualizarCaminhao(@RequestBody Caminhao caminhao) {
        try {
            Caminhao novoCaminhao = caminhaoService.atualizarCaminhao(caminhao);
            return ResponseEntity.ok(novoCaminhao);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
