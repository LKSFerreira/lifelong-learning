Assumindo uma estrutura hipotética para a tabela "Estudantes" com os seguintes campos: `ID`, `PNome` (primeiro nome), `UNome` (último nome), `Ano`, `Nota` e `Professor` (que inclui o nome completo do professor).

1. Mostre as informações apenas dos alunos aprovados (A aprovação é acima de 7,0):
```sql
SELECT *
FROM Estudantes
WHERE Nota > 7.0;
```

2. Exiba as informações dos alunos do primeiro ano com nota maior ou igual a 8,0:
```sql
SELECT *
FROM Estudantes
WHERE Ano = 1 AND Nota >= 8.0;
```

3. Exiba apenas os nomes e as notas dos alunos:
```sql
SELECT PNome, UNome, Nota
FROM Estudantes;
```

4. Crie uma tabela PROFESSOR que apresente apenas o primeiro e o último nome do professor:
```sql
CREATE TABLE PROFESSOR AS
SELECT DISTINCT SUBSTRING_INDEX(Professor, ' ', 1) AS PNome, 
                SUBSTRING_INDEX(Professor, ' ', -1) AS UNome
FROM Estudantes;
```

5. Crie uma tabela ALUNO com o primeiro e o último nome de cada:
```sql
CREATE TABLE ALUNO AS
SELECT DISTINCT PNome, UNome
FROM Estudantes;
```

Para as próximas operações de união, intersecção e diferença, é importante notar que o SQL padrão não possui um operador direto para intersecção e diferença. No entanto, podemos utilizar o operador `UNION` para a união, e combinar `JOIN` e `EXCEPT` (ou `NOT IN` dependendo do SGBD) para simular intersecção e diferença.

6. Mostre o resultado da união entre a tabela ALUNO(PNome, UNome) e a tabela PROFESSOR:
```sql
SELECT PNome, UNome FROM ALUNO
UNION
SELECT PNome, UNome FROM PROFESSOR;
```

7. Exiba o resultado da intersecção entre a tabela ALUNO(PNome, UNome) e a tabela PROFESSOR (simulando com `INNER JOIN`):
```sql
SELECT ALUNO.PNome, ALUNO.UNome
FROM ALUNO
JOIN PROFESSOR ON ALUNO.PNome = PROFESSOR.PNome AND ALUNO.UNome = PROFESSOR.UNome;
```

8. Exiba o resultado da diferença entre a tabela ALUNO(PNome, UNome) e a tabela PROFESSOR (simulando com `NOT IN`):
```sql
SELECT PNome, UNome
FROM ALUNO
WHERE (PNome, UNome) NOT IN (
    SELECT PNome, UNome
    FROM PROFESSOR
);
```

Note que a sintaxe exata pode variar dependendo do Sistema de Gerenciamento de Banco de Dados (SGBD) que você está usando. Por exemplo, alguns SGBDs podem não suportar `SUBSTRING_INDEX` ou podem ter diferentes maneiras de realizar operações de intersecção e diferença. O exemplo dado assume um SGBD compatível com a sintaxe do MySQL.