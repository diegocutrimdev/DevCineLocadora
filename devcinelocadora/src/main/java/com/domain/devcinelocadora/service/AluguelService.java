package com.domain.devcinelocadora.service;

import com.domain.devcinelocadora.model.Aluguel;

import java.util.List;

public interface AluguelService {

    Aluguel salvar(Aluguel aluguel);

    List<Aluguel> listarTodos();
}
