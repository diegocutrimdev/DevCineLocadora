package com.domain.devcinelocadora.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmeRequestDTO {

    private String titulo;
    private String diretor;
    private String genero;
    private Integer anoLancamento;
    private Boolean lancamento;
    private Integer estoque;
}
