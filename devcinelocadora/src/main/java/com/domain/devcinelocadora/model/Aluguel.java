package com.domain.devcinelocadora.model;

import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataAluguel;
    private LocalDate dataDevolucao;
    private Boolean devolvido;
    private Double valor;

    @ManyToOne(optional = false)
    private Cliente cliente;

    @ManyToOne(optional = false)
    private Filme filme;
}
