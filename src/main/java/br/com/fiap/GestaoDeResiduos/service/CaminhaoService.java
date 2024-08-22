package br.com.fiap.GestaoDeResiduos.service;

import br.com.fiap.GestaoDeResiduos.model.Caminhao;
import br.com.fiap.GestaoDeResiduos.repository.CaminhaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaminhaoService {

    @Autowired
    private CaminhaoRepository caminhaoRepository;

    public Caminhao cadastrarCaminhao(Caminhao caminhao) {
        return caminhaoRepository.save(caminhao);
    }

    public List<Caminhao> buscarTodosCaminhoes() {
        return caminhaoRepository.findAll();
    }

    public Caminhao buscarCaminhaoPorId (String id) {
        Optional<Caminhao> caminhaoOptional = caminhaoRepository.findById(id);

        if (caminhaoOptional.isPresent()) {
            return caminhaoOptional.get();
        } else {
            throw new RuntimeException("Caminhão não encontrado!");
        }

    }

    public void deletarCaminhaoPorId(String id) {
        Optional<Caminhao> caminhaoOptional = caminhaoRepository.findById(id);

        if (caminhaoOptional.isPresent()) {
            caminhaoRepository.delete(caminhaoOptional.get());
        } else {
            throw new RuntimeException("Caminhão não encontrado!");
        }
    }

    public Caminhao atualizarCaminhao(Caminhao caminhao) {
        Optional<Caminhao> caminhaoOptional = caminhaoRepository.findById(caminhao.id);

        if (caminhaoOptional.isPresent()) {
            return caminhaoRepository.save(caminhao);
        } else {
            throw new RuntimeException("Caminhão não encontrado!");
        }
    }
}
