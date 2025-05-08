package com.domain.devcinelocadora.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import com.domain.devcinelocadora.model.Cliente;
import org.springframework.web.bind.annotation.*;
import com.domain.devcinelocadora.dto.ClienteRequestDTO;
import com.domain.devcinelocadora.service.ClienteService;
import com.domain.devcinelocadora.dto.ClienteResponseDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    @Operation(summary = "Cadastra um novo cliente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ClienteResponseDTO cadastrarCliente(@RequestBody ClienteRequestDTO dto) {
        Cliente cliente = Cliente.builder()
                .nome(dto.getNome())
                .cpf(dto.getCpf())
                .build();
        Cliente clienteSalvo = clienteService.salvar(cliente);
        return toDTO(clienteSalvo);
    }


    @GetMapping
    @Operation(summary = "Lista todos os clientes cadastrados")
    public List<ClienteResponseDTO> listarClientes() {
        return clienteService.listarTodos().stream().map(this::toDTO).toList();
    }


    private ClienteResponseDTO toDTO(Cliente cliente) {
        return ClienteResponseDTO.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .cpf(cliente.getCpf())
                .build();
    }
}
