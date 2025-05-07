package com.domain.devcinelocadora.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class AluguelResponseDTO {

    private Long id;
    private String tituloFilme;
    private String nomeCliente;
    private LocalDate dataAluguel;
    private LocalDate dataDevolucao;
    private LocalDate dataDevolucaoReal;
    private boolean devolvido;
    private double valor;
}
