package com.domain.devcinelocadora.service;

import com.domain.devcinelocadora.model.Aluguel;

import java.util.List;

public interface AluguelService {

    Aluguel realizarAluguel(Long clienteId, Long filmeId);

    List<Aluguel> listarTodos();
}
