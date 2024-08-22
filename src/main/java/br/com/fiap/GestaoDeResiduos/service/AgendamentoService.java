package br.com.fiap.GestaoDeResiduos.service;

import br.com.fiap.GestaoDeResiduos.model.Agendamento;
import br.com.fiap.GestaoDeResiduos.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public Agendamento cadastrarAgendamento(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> buscarTodosAgendamentos() {
        return agendamentoRepository.findAll();
    }

    public Agendamento buscarAgendamentoPorId(String id) {
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findById(id);

        if (agendamentoOptional.isPresent()) {
            return agendamentoOptional.get();
        } else {
            throw new RuntimeException("Agendamento não existe!");
        }
    }

    public void deletarAgendamentoPorId(String id) {
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findById(id);

        if (agendamentoOptional.isPresent()) {
            agendamentoRepository.delete(agendamentoOptional.get());
        } else {
            throw new RuntimeException("Agendamento não encontrado!");
        }
    }

    public Agendamento atualizarAgendamento(Agendamento agendamento) {
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findById(agendamento.id);

        if (agendamentoOptional.isPresent()) {
            return agendamentoRepository.save(agendamento);
        } else {
            throw new RuntimeException("Agendamento não encontrado!");
        }
    }
}
