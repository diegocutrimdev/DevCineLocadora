package com.domain.devcinelocadora.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClienteResponseDTO {

    private Long id;
    private String nome;
    private String cpf;
}
