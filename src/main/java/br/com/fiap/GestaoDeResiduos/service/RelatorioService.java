package br.com.fiap.GestaoDeResiduos.service;

import br.com.fiap.GestaoDeResiduos.model.Relatorio;
import br.com.fiap.GestaoDeResiduos.repository.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RelatorioService {

    @Autowired
    private RelatorioRepository relatorioRepository;

    public Relatorio cadastarRealtorio(Relatorio relatorio) {
        return relatorioRepository.save(relatorio);
    }

    public List<Relatorio> buscarTodosRelatorios() {
        return relatorioRepository.findAll();
    }

    public Relatorio buscarRelatorioPorId(String id) {
        Optional<Relatorio> relatorioOptional = relatorioRepository.findById(id);

        if (relatorioOptional.isPresent()) {
            return relatorioOptional.get();
        } else {
            throw new RuntimeException("Relatório não encontrado");
        }
    }

    public void deletarRelatorio(String id) {
        Optional<Relatorio> relatorioOptional = relatorioRepository.findById(id);

        if (relatorioOptional.isPresent()) {
            relatorioRepository.delete(relatorioOptional.get());
        } else {
            throw new RuntimeException("Relatório não encontrado");
        }
    }

    public Relatorio atualizarRelatorio(Relatorio relatorio) {
        Optional<Relatorio> relatorioOptional = relatorioRepository.findById(relatorio.id);

        if (relatorioOptional.isPresent()) {
            return relatorioRepository.save(relatorio);
        } else {
            throw new RuntimeException("Relatório não encontrado!");
        }
    }
}
