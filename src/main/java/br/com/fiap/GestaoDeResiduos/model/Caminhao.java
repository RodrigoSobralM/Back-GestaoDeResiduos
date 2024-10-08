package br.com.fiap.GestaoDeResiduos.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "caminhao_entity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Caminhao {
    @Id
    public String id;
    private String numeroPlaca;
    private Posicao posicaoAtual;
    private String status;
    private String ultimaManutencao;
    private Motorista motorista;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Posicao {
    private double latitude;
    private double longitude;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Motorista {
    private String nome;
    private String licenca;
}
