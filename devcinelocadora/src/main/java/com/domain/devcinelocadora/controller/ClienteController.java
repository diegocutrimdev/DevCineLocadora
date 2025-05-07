package com.domain.devcinelocadora.controller;

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
    public ClienteResponseDTO cadastrarCliente(@RequestBody ClienteRequestDTO dto) {
        Cliente cliente = Cliente.builder()
                .nome(dto.getNome())
                .cpf(dto.getCpf())
                .build();

        Cliente clienteSalvo = clienteService.salvar(cliente);
        return toDTO(clienteSalvo);
    }


    @GetMapping
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
