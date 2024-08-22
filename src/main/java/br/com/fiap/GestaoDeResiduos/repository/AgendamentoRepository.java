package br.com.fiap.GestaoDeResiduos.repository;

import br.com.fiap.GestaoDeResiduos.model.Agendamento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AgendamentoRepository extends MongoRepository<Agendamento, String> {
}
