package com.domain.devcinelocadora.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import com.domain.devcinelocadora.model.Aluguel;
import org.springframework.web.bind.annotation.*;
import com.domain.devcinelocadora.dto.AluguelRequestDTO;
import com.domain.devcinelocadora.service.AluguelService;
import com.domain.devcinelocadora.dto.AluguelResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alugueis")
public class AluguelController {

    private final AluguelService aluguelService;

    @PostMapping
    @Operation(summary = "Realiza um novo aluguel de filme")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Aluguel realizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public AluguelResponseDTO realizarAluguel(@RequestBody AluguelRequestDTO dto) {
        Aluguel aluguel = aluguelService.realizarAluguel(dto.getClienteId(), dto.getFilmeId());
        return toDTO(aluguel);
    }


    @GetMapping
    @Operation(summary = "Lista todos os aluguéis")
    public List<AluguelResponseDTO> listarTodos() {
        return aluguelService.listarTodos()
                .stream()
                .map(this::toDTO)
                .collect(toList());
    }


    @PutMapping("/{id}/devolucao")
    @Operation(summary = "Registra a devolução de um aluguel")
    public AluguelResponseDTO devolverFilme(@PathVariable Long id) {
        Aluguel aluguel = aluguelService.registrarDevolucao(id);
        return toDTO(aluguel);
    }


    @GetMapping("em-aberto")
    @Operation(summary = "Lista todos os aluguéis em aberto")
    public List<AluguelResponseDTO> listarEmAberto() {
        return aluguelService.listarEmAberto().stream().map(this::toDTO).toList();
    }


    @GetMapping("/atrasados")
    @Operation(summary = "Lista todos os aluguéis em atraso")
    public List<AluguelResponseDTO> listarAtrasados() {
        return aluguelService.listarAtrasados().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
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
