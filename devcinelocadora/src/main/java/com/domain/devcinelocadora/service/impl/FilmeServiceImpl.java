package com.domain.devcinelocadora.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.domain.devcinelocadora.model.Filme;
import com.domain.devcinelocadora.service.FilmeService;
import com.domain.devcinelocadora.repository.FilmeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmeServiceImpl implements FilmeService {

    private final FilmeRepository filmeRepository;

    @Override
    public Filme salvar(Filme filme) {
        return filmeRepository.save(filme);
    }

    @Override
    public List<Filme> listarTodos() {
        return filmeRepository.findAll();
    }

    @Override
    public List<Filme> listarDisponiveis() {
        return filmeRepository.findAll()
                .stream()
                .filter(filme -> filme.getEstoque() != null && filme.getEstoque() > 0)
                .toList();
    }
}
