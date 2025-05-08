-- Inserir Clientes
INSERT INTO cliente (nome, email, cpf, data_nascimento) 
VALUES ('João Silva', 'joao.silva@example.com', '12345678901', '1985-03-22');

INSERT INTO cliente (nome, email, cpf, data_nascimento) 
VALUES ('Maria Oliveira', 'maria.oliveira@example.com', '98765432100', '1990-07-15');

-- Inserir Filmes
INSERT INTO filme (titulo, diretor, genero, ano_lancamento, lancamento, estoque)
VALUES ('O Poderoso Chefão', 'Francis Ford Coppola', 'Drama', 1972, false, 3);

INSERT INTO filme (titulo, diretor, genero, ano_lancamento, lancamento, estoque)
VALUES ('Matrix', 'Wachowski', 'Ação', 1999, false, 5);

INSERT INTO filme (titulo, diretor, genero, ano_lancamento, lancamento, estoque)
VALUES ('Barbie', 'Greta Gerwig', 'Comédia', 2023, true, 2);

-- Aluguéis
INSERT INTO aluguel (cliente_id, filme_id, data_aluguel, data_devolucao, devolvido, valor)
VALUES (1, 1, '2025-05-01', '2025-05-04', false, 5.0);

INSERT INTO aluguel (cliente_id, filme_id, data_aluguel, data_devolucao, devolvido, valor)
VALUES (2, 2, '2025-05-02', '2025-05-05', false, 7.0);