package com.domain.devcinelocadora.service;

import com.domain.devcinelocadora.model.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente salvar(Cliente cliente);

    List<Cliente> listarTodos();
}
