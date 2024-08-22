package br.com.fiap.GestaoDeResiduos.repository;

import br.com.fiap.GestaoDeResiduos.model.Morador;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MoradorRepository extends MongoRepository<Morador, String> {
}
