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
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true)
    private String cpf;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
}
