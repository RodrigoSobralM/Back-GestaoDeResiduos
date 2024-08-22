package br.com.fiap.GestaoDeResiduos.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "agendamento_entity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Agendamento {

    @Id
    public String id;

    private String area;

    private List<String> diasColeta;

    private String proximaColeta;

    private String caminhao;

}

