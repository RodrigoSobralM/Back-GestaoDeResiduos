package br.com.fiap.GestaoDeResiduos.repository;

import br.com.fiap.GestaoDeResiduos.model.Relatorio;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RelatorioRepository extends MongoRepository<Relatorio, String> {
}
