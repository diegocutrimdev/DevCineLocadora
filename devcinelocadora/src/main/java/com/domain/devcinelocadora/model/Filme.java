package com.domain.devcinelocadora.model;

import lombok.*;
import jakarta.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String diretor;
    private String genero;
    private Integer anoLancamento;
    private Boolean lancamento;
    private Integer estoque;
}
