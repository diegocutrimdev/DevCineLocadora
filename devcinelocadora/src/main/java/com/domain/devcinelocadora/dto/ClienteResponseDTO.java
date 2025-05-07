package com.domain.devcinelocadora.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClienteResponseDTO {

    private Long id;
    private String nome;
    private String cpf;
}
