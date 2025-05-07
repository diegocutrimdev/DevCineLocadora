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
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true)
    private String cpf;
    private LocalDate dataNascimento;
}
