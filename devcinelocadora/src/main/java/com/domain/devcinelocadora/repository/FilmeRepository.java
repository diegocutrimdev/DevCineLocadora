package com.domain.devcinelocadora.repository;

import com.domain.devcinelocadora.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
