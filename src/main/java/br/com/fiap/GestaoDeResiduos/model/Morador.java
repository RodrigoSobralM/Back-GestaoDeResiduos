package br.com.fiap.GestaoDeResiduos.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "morador_entity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Morador {

    @Id
    public String id;

    private String nome;

    private String endereco;

    private List<String> notificacoes;

    private String areaColeta;
}
