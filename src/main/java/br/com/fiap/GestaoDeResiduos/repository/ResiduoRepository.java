package br.com.fiap.GestaoDeResiduos.repository;

import br.com.fiap.GestaoDeResiduos.model.Residuo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResiduoRepository extends MongoRepository<Residuo, String> {
}
