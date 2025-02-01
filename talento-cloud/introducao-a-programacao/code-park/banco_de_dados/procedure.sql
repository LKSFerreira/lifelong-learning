-- Cria o banco de dados 'EmpresaVendas'
CREATE DATABASE IF NOT EXISTS EmpresaVendas;

-- Seleciona o banco de dados para uso
USE EmpresaVendas;

-- Cria a tabela 'produtos'
CREATE TABLE IF NOT EXISTS produtos (
    id_produto INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL
);

-- Cria a tabela 'compras'
CREATE TABLE IF NOT EXISTS compras (
    id_compra INT AUTO_INCREMENT PRIMARY KEY,
    id_produto INT NOT NULL,
    quantidade INT NOT NULL,
    data_compra DATE NOT NULL,
    FOREIGN KEY (id_produto) REFERENCES produtos(id_produto)
);

-- Inserção de linguagens de programação como produtos para teste
INSERT INTO produtos (nome, preco) VALUES ('Python', 99.99);
INSERT INTO produtos (nome, preco) VALUES ('Java', 95.99);
INSERT INTO produtos (nome, preco) VALUES ('C#', 89.99);
INSERT INTO produtos (nome, preco) VALUES ('JavaScript', 105.50);
INSERT INTO produtos (nome, preco) VALUES ('Swift', 120.00);
INSERT INTO produtos (nome, preco) VALUES ('Go', 110.00);
INSERT INTO produtos (nome, preco) VALUES ('Kotlin', 93.00);
INSERT INTO produtos (nome, preco) VALUES ('Rust', 135.50);
INSERT INTO produtos (nome, preco) VALUES ('Ruby', 80.75);
INSERT INTO produtos (nome, preco) VALUES ('TypeScript', 107.40);
INSERT INTO produtos (nome, preco) VALUES ('C', 70.00);
INSERT INTO produtos (nome, preco) VALUES ('C++', 77.30);
INSERT INTO produtos (nome, preco) VALUES ('PHP', 58.90);
INSERT INTO produtos (nome, preco) VALUES ('Perl', 54.45);
INSERT INTO produtos (nome, preco) VALUES ('R', 115.60);
INSERT INTO produtos (nome, preco) VALUES ('Scala', 130.00);
INSERT INTO produtos (nome, preco) VALUES ('Haskell', 99.00);
INSERT INTO produtos (nome, preco) VALUES ('Dart', 90.00);
INSERT INTO produtos (nome, preco) VALUES ('Lua', 75.00);
INSERT INTO produtos (nome, preco) VALUES ('SQL', 65.00);

-- Inserção de alguns registros de compras para teste
-- Note que os IDs dos produtos agora devem ser consistentes com os inseridos acima.
INSERT INTO compras (id_produto, quantidade, data_compra) VALUES (1, 10, CURDATE());
INSERT INTO compras (id_produto, quantidade, data_compra) VALUES (2, 5, CURDATE());
INSERT INTO compras (id_produto, quantidade, data_compra) VALUES (3, 3, CURDATE() - INTERVAL 1 DAY);
INSERT INTO compras (id_produto, quantidade, data_compra) VALUES (4, 7, CURDATE() - INTERVAL 1 DAY);

-- Cria a procedure 'RelatorioDiarioCompras' para gerar o relatório de compras diárias
DELIMITER //
CREATE PROCEDURE RelatorioDiarioCompras(IN data_report DATE)
BEGIN
    SELECT p.id_produto, p.nome, SUM(c.quantidade) as quantidade_total
    FROM compras c
    JOIN produtos p ON c.id_produto = p.id_produto
    WHERE c.data_compra = data_report
    GROUP BY p.id_produto, p.nome;
END;
//
DELIMITER ;

-- Para chamar a procedure e obter o relatório para uma data específica, use:
-- CALL RelatorioDiarioCompras('2023-04-01');

DELIMITER //
CREATE PROCEDURE RelatorioTodasCompras()
BEGIN
    SELECT p.id_produto, p.nome, c.data_compra, SUM(c.quantidade) as quantidade_total
    FROM compras c
    JOIN produtos p ON c.id_produto = p.id_produto
    GROUP BY c.data_compra, p.id_produto, p.nome
    ORDER BY c.data_compra, p.id_produto;
END;
//
DELIMITER ;

-- Para chamar a procedure e obter o relatório de todas as compras, use:
-- CALL RelatorioTodasCompras();