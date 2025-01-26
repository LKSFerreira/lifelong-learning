-- Criação da tabela disciplinas
CREATE TABLE disciplinas(
  disciplina_id SERIAL PRIMARY KEY,
  disciplina_nome VARCHAR(50) NOT NULL,
  disciplina_professor VARCHAR(50) NOT NULL
);

-- Inserção de dados na tabela disciplinas
INSERT INTO disciplinas(disciplina_nome, disciplina_professor) VALUES
  ('Banco de Dados', 'Fulano de Tal'),
  ('Python', 'Siclano de Tal'),
  ('Java', 'Beltrano de Tal'),
  ('Estrutura de Dados', 'Deltrano de Tal'),
  ('Redes de Computadores', 'Eltrano de Tal');

-- Seleção de todos os registros da tabela disciplinas
SELECT * FROM disciplinas;

-- Criação da tabela alunos
CREATE TABLE alunos (
  aluno_id SERIAL PRIMARY KEY,
  aluno_nome VARCHAR(50) NOT NULL,
  disciplina_id INTEGER,
  
  CONSTRAINT fk_disciplina FOREIGN KEY (disciplina_id) REFERENCES disciplinas (disciplina_id)
);

-- Inserção de dados na tabela alunos
INSERT INTO alunos(aluno_nome, disciplina_id) VALUES
  ('Alice', 1),
  ('Bruno', 1),
  ('Carlos', 2),
  ('Diana', 3),
  ('Eduardo', NULL),
  ('Fernanda', NULL),
  ('Gabriel', 2),
  ('Helena', 3),
  ('Igor', NULL),
  ('Juliana', 4);

-- INNER JOIN
SELECT alu.aluno_nome, dis.disciplina_nome
FROM alunos alu
INNER JOIN disciplinas dis ON alu.disciplina_id = dis.disciplina_id;

-- LEFT JOIN
SELECT alu.aluno_nome, dis.disciplina_nome
FROM alunos alu
LEFT JOIN disciplinas dis ON alu.disciplina_id = dis.disciplina_id;

-- RIGHT JOIN
SELECT alu.aluno_nome, dis.disciplina_nome
FROM alunos alu
RIGHT JOIN disciplinas dis ON alu.disciplina_id = dis.disciplina_id;

-- FULL OUTER JOIN
SELECT alu.aluno_nome, dis.disciplina_nome
FROM alunos alu
FULL OUTER JOIN disciplinas dis ON alu.disciplina_id = dis.disciplina_id;

-- Primeira consulta SELECT
SELECT aluno_nome FROM alunos
UNION
-- Segunda consulta SELECT
SELECT disciplina_nome FROM disciplinas;

-- Primeira consulta SELECT
SELECT aluno_nome FROM alunos
UNION ALL
-- Segunda consulta SELECT
SELECT disciplina_nome FROM disciplinas;