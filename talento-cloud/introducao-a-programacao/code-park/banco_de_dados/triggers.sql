-- Cria o banco de dados
CREATE DATABASE IF NOT EXISTS BancoDeDadosExemplo;

-- Seleciona o banco de dados para uso
USE BancoDeDadosExemplo;

-- Cria a tabela 'usuario'
CREATE TABLE IF NOT EXISTS usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Cria a tabela 'logs'
CREATE TABLE IF NOT EXISTS logs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    db_user VARCHAR(255) NOT NULL,
    acao VARCHAR(255) NOT NULL,
    data_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Cria os triggers para registrar ações na tabela 'usuario'
DELIMITER //

CREATE TRIGGER antes_de_inserir_usuario
AFTER INSERT ON usuario FOR EACH ROW
BEGIN
    INSERT INTO logs (db_user, acao) VALUES (USER(), 'INSERT');
END;

CREATE TRIGGER antes_de_atualizar_usuario
AFTER UPDATE ON usuario FOR EACH ROW
BEGIN
    INSERT INTO logs (db_user, acao) VALUES (USER(), 'UPDATE');
END;

CREATE TRIGGER antes_de_deletar_usuario
AFTER DELETE ON usuario FOR EACH ROW
BEGIN
    INSERT INTO logs (db_user, acao) VALUES (USER(), 'DELETE');
END;

DELIMITER ;