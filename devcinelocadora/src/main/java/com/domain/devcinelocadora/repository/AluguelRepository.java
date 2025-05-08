package com.domain.devcinelocadora.repository;

import com.domain.devcinelocadora.model.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.time.LocalDate;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

    List<Aluguel> findByDevolvidoFalse();

    List<Aluguel> findByDevolvidoFalseAndDataDevolucaoBefore(LocalDate dataHoje);
}
