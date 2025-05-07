package com.domain.devcinelocadora.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.domain.devcinelocadora.model.Cliente;
import com.domain.devcinelocadora.service.ClienteService;
import com.domain.devcinelocadora.repository.ClienteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }
}
