package com.domain.devcinelocadora.service;

import com.domain.devcinelocadora.model.Filme;

import java.util.List;

public interface FilmeService {

    Filme salvar(Filme filme);

    List<Filme> listarTodos();

    Filme buscarPorId(Long id);

    List<Filme> listarDisponiveis();
}
