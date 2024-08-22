package br.com.fiap.GestaoDeResiduos.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "relatorio_entity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Relatorio {

    @Id
    public String id;

    private Date data;

    private String totalResiduosColetados;

    private Divisao divisao;

}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Divisao {
    private String organico;
    private String reciclavel;
}
