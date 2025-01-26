Tabela Clientes (antes da normalização):

| Identificador | Nome | Telefones | Endereço | E-mail |
|-  |-              |-                      |-                                                              |-
| 1 | Reinaldo      | 9999-9999, 8888-8888  | Rua das Flores, 123, São Paulo - SP, 11345-000,               | reinaldo@email.com, reinaldo000@gmail.com
| 2 | Nestor        | 7777-7777             | Av. Brasil, 456, Santo - SP, 00031-123, Brasil                | nestor.souza@email.com
| 3 | Raquel        | 6666-6666, 5555-5555  | Rua dos Sonhos, 789, Salvador - BA, 22345-678, Brasil         | raquel@outlook.com
| 4 | Tati          | 4444-4444             | Rua das Pedras, 321, Rio de Janeiro - RJ, 45678-901, Brasil   | tai123@hotmail.com, tati00@gmail.com
| 5 | Lia           | 3333-3333, 2222-2222  | Rua das Árvores, 987, Belo Horizonte - MG, 56789-012, Brasil  | lia@yahoo.com.br
| 6 | Paty          | 1111-1111             | Rua das Praias, 654, Florianópolis - SC, 34567-890, Brasil    | paty@careca.com.br

Para transformar esta tabela em 1FN, precisamos garantir que a coluna `Telefones`, `Endereços` e `E-mail`  não contenha múltiplos valores, ou valores compostos. Será feito então a criação de 3 tabelas para normalizar os dados.

Tabela Clientes (Primeira Forma Normal - 1FN):

| ID | Nome | Contato | Endereço | E-mail |
|-  |-              |-                      |-                                                              |-
| 1 | Reinaldo      | 1 |   1   |   1
| 2 | Nestor        | 2 |   2   |   2
| 3 | Raquel        | 3 |   3   |   3
| 4 | Tati          | 4 |   4   |   4
| 5 | Lia           | 5 |   5   |   5
| 6 | Paty          | 6 |   6   |   6
___

Tabela Contato (Primeira Forma Normal - 1FN):

| ID | ID_Cliente | Telefone |
|-  |-              |-                      |
| 1 | 1           | 9999-9999
| 2 | 1           | 8888-8888
| 3 | 2           | 7777-7777
| 4 | 3           | 6666-6666
| 5 | 3           | 5555-5555
| 6 | 4           | 4444-4444
| 7 | 5           | 3333-3333
| 8 | 5           | 2222-2222
| 9 | 6           | 1111-1111
___

Tabela Endereço (Primeira Forma Normal - 1FN):

| ID | ID_Cliente | Nome da Rua | Número | Cidade | Estado | CEP | País |
|-  |-              |-                      |-                                                              |-      |-      |-      |-      |
| 1 | 1           | Rua das Flores | 123 | São Paulo | SP | 11345-000 | Brasil
| 2 | 2           | Av. Brasil | 456 | Santo | SP | 00031-123 | Brasil
| 3 | 3           | Rua dos Sonhos | 789 | Salvador | BA | 22345-678 | Brasil
| 4 | 4           | Rua das Pedras | 321 | Rio de Janeiro | RJ | 45678-901 | Brasil
| 5 | 5           | Rua das Árvores | 987 | Belo Horizonte | MG | 56789-012 | Brasil
| 6 | 6           | Rua das Praias | 654 | Florianópolis | SC | 34567-890 | Brasil
___

Tabela E-mail (Primeira Forma Normal - 1FN):

| ID | ID_Cliente | E-mail |
|-  |-              |-                      |
| 1 | 1           | reinaldo@email.com
| 2 | 1           | reinaldo000@gmail.com
| 3 | 2           | nestor.souza@email.com
| 4 | 3           | tai123@hotmail.com
| 5 | 3           | tati00@gmail.com
| 6 | 3           | lia@yahoo.com.br
| 7 | 4           | paty@careca.com.br