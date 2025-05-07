package com.domain.devcinelocadora.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FilmeResponseDTO {

    private Long id;
    private String titulo;
    private String diretor;
    private String genero;
    private Integer anoLancamento;
    private Boolean lancamento;
    private Integer estoque;
}
