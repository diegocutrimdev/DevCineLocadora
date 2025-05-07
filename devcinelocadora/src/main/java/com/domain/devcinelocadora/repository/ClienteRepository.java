package com.domain.devcinelocadora.repository;

import com.domain.devcinelocadora.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
