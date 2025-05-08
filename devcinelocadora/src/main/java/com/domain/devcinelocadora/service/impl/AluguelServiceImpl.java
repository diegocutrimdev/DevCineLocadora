package com.domain.devcinelocadora.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.domain.devcinelocadora.model.Filme;
import com.domain.devcinelocadora.model.Aluguel;
import com.domain.devcinelocadora.model.Cliente;
import jakarta.persistence.EntityNotFoundException;
import com.domain.devcinelocadora.service.AluguelService;
import com.domain.devcinelocadora.repository.FilmeRepository;
import com.domain.devcinelocadora.repository.AluguelRepository;
import com.domain.devcinelocadora.repository.ClienteRepository;

import java.util.List;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AluguelServiceImpl implements AluguelService {

    private final FilmeRepository filmeRepository;
    private final AluguelRepository aluguelRepository;
    private final ClienteRepository clienteRepository;


    @Override
    public Aluguel realizarAluguel(Long clienteId, Long filmeId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID: " + clienteId));

        Filme filme = filmeRepository.findById(filmeId).orElseThrow(() -> new EntityNotFoundException("Filme não encontrado com ID: " + filmeId));

        if (filme.getEstoque() == null || filme.getEstoque() <= 0) {
            throw new IllegalStateException("Filme sem estoque disponível");
        }

        filme.setEstoque(filme.getEstoque() - 1);
        filmeRepository.save(filme);

        LocalDate hoje = LocalDate.now();
        LocalDate dataDevolucao = filme.getLancamento() ? hoje.plusDays(1) : hoje.plusDays(3);
        double valor = filme.getLancamento() ? 7.0 : 5.0;

        Aluguel aluguel = Aluguel.builder().cliente(cliente).filme(filme).dataAluguel(hoje).dataDevolucao(dataDevolucao).devolvido(false).valor(valor).build();
        return aluguelRepository.save(aluguel);
    }


    @Override
    public Aluguel registrarDevolucao(Long aluguelId) {
        Aluguel aluguel = aluguelRepository.findById(aluguelId).orElseThrow(() -> new EntityNotFoundException("Aluguel não encontrado com ID: " + aluguelId));

        if (aluguel.getDevolvido()) {
            throw new IllegalStateException("Filme já foi devolvido.");
        }

        aluguel.setDevolvido(true);
        aluguel.setDataDevolucaoReal(LocalDate.now());

        Filme filme = aluguel.getFilme();
        filme.setEstoque(filme.getEstoque() + 1);
        filmeRepository.save(filme);

        if (aluguel.getDataDevolucaoReal().isAfter(aluguel.getDataDevolucao())) {
            long diasAtraso = aluguel.getDataDevolucao().until(aluguel.getDataDevolucaoReal()).getDays();
            double multa = diasAtraso * 2.0;
            aluguel.setValor(aluguel.getValor() + multa);
        }

        return aluguelRepository.save(aluguel);
    }


    @Override
    public List<Aluguel> listarTodos() {
        return aluguelRepository.findAll();
    }


    @Override
    public List<Aluguel> listarEmAberto() {
        return aluguelRepository.findByDevolvidoFalse();
    }


    @Override
    public List<Aluguel> listarAtrasados() {
        return aluguelRepository.findByDevolvidoFalseAndDataDevolucaoBefore(LocalDate.now());
    }
}
