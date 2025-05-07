package com.domain.devcinelocadora.controller;

import lombok.RequiredArgsConstructor;
import com.domain.devcinelocadora.model.Aluguel;
import org.springframework.web.bind.annotation.*;
import com.domain.devcinelocadora.dto.AluguelRequestDTO;
import com.domain.devcinelocadora.service.AluguelService;
import com.domain.devcinelocadora.dto.AluguelResponseDTO;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alugueis")
public class AluguelController {

    private final AluguelService aluguelService;

    @PostMapping
    public AluguelResponseDTO realizarAluguel(@RequestBody AluguelRequestDTO dto) {
        Aluguel aluguel = aluguelService.realizarAluguel(dto.getClienteId(), dto.getFilmeId());

        return toDTO(aluguel);
    }


    @GetMapping
    public List<AluguelResponseDTO> listarTodos() {
        return aluguelService.listarTodos()
                .stream()
                .map(this::toDTO)
                .collect(toList());
    }


    private AluguelResponseDTO toDTO(Aluguel aluguel) {
        return AluguelResponseDTO.builder()
                .id(aluguel.getId())
                .tituloFilme(aluguel.getFilme().getTitulo())
                .nomeCliente(aluguel.getCliente().getNome())
                .dataAluguel(aluguel.getDataAluguel())
                .dataDevolucao(aluguel.getDataDevolucao())
                .devolvido(aluguel.getDevolvido())
                .valor(aluguel.getValor())
                .build();
    }
}
