package br.com.fiap.GestaoDeResiduos.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "residuo_entity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Residuo {

    @Id
    public String id;

    private String tipo;

    private String descricao;

    private String instrucoesSeparacao;

}
