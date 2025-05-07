package com.domain.devcinelocadora.controller;

import lombok.RequiredArgsConstructor;
import com.domain.devcinelocadora.model.Filme;
import org.springframework.web.bind.annotation.*;
import com.domain.devcinelocadora.service.FilmeService;
import com.domain.devcinelocadora.dto.FilmeRequestDTO;
import com.domain.devcinelocadora.dto.FilmeResponseDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService filmeService;

    @PostMapping
    public FilmeResponseDTO cadastrarFilme(@RequestBody FilmeRequestDTO dto) {
        Filme filme = Filme.builder()
                .titulo(dto.getTitulo())
                .diretor(dto.getDiretor())
                .genero(dto.getGenero())
                .anoLancamento(dto.getAnoLancamento())
                .lancamento(dto.getLancamento())
                .estoque(dto.getEstoque())
                .build();

        Filme filmeSalvo = filmeService.salvar(filme);
        return toDTO(filmeSalvo);
    }


    @GetMapping
    public List<FilmeResponseDTO> listarFilmes() {
        return filmeService.listarTodos().stream().map(this::toDTO).toList();
    }


    private FilmeResponseDTO toDTO(Filme filme) {
        return FilmeResponseDTO.builder()
                .id(filme.getId())
                .titulo(filme.getTitulo())
                .diretor(filme.getDiretor())
                .genero(filme.getGenero())
                .anoLancamento(filme.getAnoLancamento())
                .lancamento(filme.getLancamento())
                .estoque(filme.getEstoque())
                .build();
    }
}
