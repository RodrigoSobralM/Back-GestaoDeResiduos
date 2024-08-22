package br.com.fiap.GestaoDeResiduos.service;

import br.com.fiap.GestaoDeResiduos.model.Morador;
import br.com.fiap.GestaoDeResiduos.repository.MoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoradorService {

    @Autowired
    private MoradorRepository moradorRepository;

    public Morador cadastrarMorador(Morador morador) {
        return moradorRepository.save(morador);
    }

    public List<Morador> buscarTodosMoradores() {
        return moradorRepository.findAll();
    }

    public Morador buscarMoradorPorId(String id) {
        Optional<Morador> moradorOptional = moradorRepository.findById(id);

        if (moradorOptional.isPresent()) {
            return moradorOptional.get();
        } else {
            throw new RuntimeException("Morador não encontrado!");
        }
    }

    public void deletarMorador(String id) {
        Optional<Morador> moradorOptional = moradorRepository.findById(id);

        if (moradorOptional.isPresent()) {
            moradorRepository.delete(moradorOptional.get());
        } else {
            throw new RuntimeException("Morador não existe!");
        }

    }

    public Morador atualizarMorador(Morador morador) {
        Optional<Morador> moradorOptional = moradorRepository.findById(morador.id);

        if (moradorOptional.isPresent()) {
            return moradorRepository.save(morador);
        } else {
            throw new RuntimeException("Morador não encontrado!");
        }
    }
}
