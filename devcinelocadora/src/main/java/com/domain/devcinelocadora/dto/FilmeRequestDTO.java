package com.domain.devcinelocadora.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
public class FilmeRequestDTO {

    @NotBlank(message = "O título é obrigatório.")
    private String titulo;

    @NotBlank(message = "O diretor é obrigatório.")
    private String diretor;

    @NotBlank(message = "O gênero é obrigatório.")
    private String genero;

    @NotNull(message = "O ano de lançamento é obrigatório.")
    @Min(value = 1900, message = "Ano de lançamento inválido.")
    private Integer anoLancamento;

    @NotNull(message = "O campo de lançamento é obrigatório.")
    private Boolean lancamento;

    @NotNull(message = "O estoque é obrigatório.")
    @Min(value = 1, message = "O estoque deve ser no mínimo 1.")
    private Integer estoque;
}
