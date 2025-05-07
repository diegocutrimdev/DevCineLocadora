package com.domain.devcinelocadora.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.domain.devcinelocadora.model.Aluguel;
import com.domain.devcinelocadora.service.AluguelService;
import com.domain.devcinelocadora.repository.AluguelRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AluguelServiceImpl implements AluguelService {

    private final AluguelRepository aluguelRepository;

    @Override
    public Aluguel salvar(Aluguel aluguel) {
        return aluguelRepository.save(aluguel);
    }

    @Override
    public List<Aluguel> listarTodos() {
        return aluguelRepository.findAll();
    }
}
