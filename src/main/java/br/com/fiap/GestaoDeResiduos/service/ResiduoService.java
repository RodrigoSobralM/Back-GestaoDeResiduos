package br.com.fiap.GestaoDeResiduos.service;

import br.com.fiap.GestaoDeResiduos.model.Residuo;
import br.com.fiap.GestaoDeResiduos.repository.ResiduoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResiduoService {

    @Autowired
    private ResiduoRepository residuoRepository;

    public Residuo cadastrarResiduo(Residuo residuo) {
        return residuoRepository.save(residuo);
    }

    public List<Residuo> buscarTodosResiduos() {
        return residuoRepository.findAll();
    }

    public Residuo buscarResiduoPorId(String id) {
        Optional<Residuo> residuoOptional = residuoRepository.findById(id);

        if (residuoOptional.isPresent()) {
            return residuoOptional.get();
        } else {
            throw new RuntimeException("Resíduo não encontrado!");
        }
    }

    public void deletarResiduo(String id) {
        Optional<Residuo> residuoOptional = residuoRepository.findById(id);

        if (residuoOptional.isPresent()) {
            residuoRepository.delete(residuoOptional.get());
        } else {
            throw new RuntimeException("Resíduo não encontrado!");
        }
    }

    public Residuo atualizarResiduo(Residuo residuo) {
        Optional<Residuo> residuoOptional = residuoRepository.findById(residuo.id);

        if (residuoOptional.isPresent()) {
            return residuoRepository.save(residuo);
        } else {
            throw new RuntimeException("Resíduo não encontrado!");
        }
    }
}
