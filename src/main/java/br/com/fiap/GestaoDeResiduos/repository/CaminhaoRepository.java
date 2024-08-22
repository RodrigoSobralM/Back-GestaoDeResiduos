package br.com.fiap.GestaoDeResiduos.repository;

import br.com.fiap.GestaoDeResiduos.model.Caminhao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CaminhaoRepository extends MongoRepository<Caminhao, String> {
}
