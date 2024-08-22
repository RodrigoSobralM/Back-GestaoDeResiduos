package br.com.fiap.GestaoDeResiduos.controller;

import br.com.fiap.GestaoDeResiduos.model.Residuo;
import br.com.fiap.GestaoDeResiduos.service.ResiduoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/residuo")
public class ResiduoController {

    @Autowired
    private ResiduoService residuoService;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Residuo cadastrarResiduo(@RequestBody Residuo residuo) {
        return residuoService.cadastrarResiduo(residuo);
    }

    @GetMapping("/buscar")
    @ResponseStatus(HttpStatus.OK)
    public List<Residuo> buscarTodosResiduos() {
        return residuoService.buscarTodosResiduos();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Residuo> buscarResiduoPorId(@PathVariable String id) {
        try {
            return ResponseEntity.ok(residuoService.buscarResiduoPorId(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarResiduo(@PathVariable String id) {
        residuoService.deletarResiduo(id);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Residuo> atualizarResiduo(@RequestBody Residuo residuo) {
        try {
            Residuo novoResiduo = residuoService.atualizarResiduo(residuo);
            return ResponseEntity.ok(novoResiduo);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
