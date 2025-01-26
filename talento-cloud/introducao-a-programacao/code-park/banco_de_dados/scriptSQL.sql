-- Criar o banco de dados ESCOLA
CREATE DATABASE ESCOLA;

-- Para usar o banco de dados ESCOLA
USE ESCOLA;

-- Criar a tabela ALUNO
CREATE TABLE ALUNO (
    id INT PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255),
    endereco VARCHAR(255)
);

-- Inserir registros de exemplo na tabela ALUNO
INSERT INTO ALUNO (id, nome, email, endereco) VALUES
(1, 'João Silva', 'joao.silva@email.com', 'Rua das Flores, 123'),
(2, 'Maria Oliveira', 'maria.oliveira@email.com', 'Avenida do Sol, 456'),
(3, 'Usuário', 'usuario@email.com', 'Alameda das Árvores, 789');

-- Criar a tabela SESSAO
CREATE TABLE SESSAO (
    id INT PRIMARY KEY,
    descricao VARCHAR(255),
    localizacao VARCHAR(255)
);

-- Inserir registros de exemplo na tabela SESSAO
INSERT INTO SESSAO (id, descricao, localizacao) VALUES
(1, 'Sessão de Literatura', 'Primeiro Andar - Corredor B'),
(2, 'Sessão de Ciências', 'Segundo Andar - Corredor A'),
(3, 'Sessão de Arte', 'Terceiro Andar - Corredor C');

-- Criar a tabela LIVRO
CREATE TABLE LIVRO (
    cod_livro INT PRIMARY KEY,
    titulo VARCHAR(255),
    autor VARCHAR(255),
    cod_sessao INT,
    FOREIGN KEY (cod_sessao) REFERENCES SESSAO(id)
);

-- Inserir registros de exemplo na tabela LIVRO
INSERT INTO LIVRO (cod_livro, titulo, autor, cod_sessao) VALUES
(101, 'Dom Casmurro', 'Machado de Assis', 1),
(102, 'A Origem das Espécies', 'Charles Darwin', 2),
(103, 'O Grito', 'Edvard Munch', 3);

-- Criar a tabela EMPRESTIMO
CREATE TABLE EMPRESTIMO (
    id INT PRIMARY KEY,
    data_hora DATETIME,
    matric_aluno INT,
    data_devolucao DATE,
    FOREIGN KEY (matric_aluno) REFERENCES ALUNO(id)
);

-- Inserir registros de exemplo na tabela EMPRESTIMO
INSERT INTO EMPRESTIMO (id, data_hora, matric_aluno, data_devolucao) VALUES
(1001, '2023-04-01 10:00:00', 1, '2023-04-15'),
(1002, '2023-04-02 11:30:00', 2, '2023-04-16'),
(1003, '2023-04-03 14:45:00', 3, '2023-04-17');

-- Criar a tabela LIVRO_EMPRESTIMO
CREATE TABLE LIVRO_EMPRESTIMO (
    cod_livro INT,
    cod_emprestimo INT,
    PRIMARY KEY (cod_livro, cod_emprestimo),
    FOREIGN KEY (cod_livro) REFERENCES LIVRO(cod_livro),
    FOREIGN KEY (cod_emprestimo) REFERENCES EMPRESTIMO(id)
);

-- Inserir registros de exemplo na tabela LIVRO_EMPRESTIMO
INSERT INTO LIVRO_EMPRESTIMO (cod_livro, cod_emprestimo) VALUES
(101, 1001),
(102, 1002),
(103, 1003);