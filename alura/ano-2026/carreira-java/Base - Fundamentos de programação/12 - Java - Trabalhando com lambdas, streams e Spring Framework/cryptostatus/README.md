# Java: Trabalhando com Lambdas, Streams e Spring Framework

Repositório de estudos do curso da Alura sobre recursos modernos do Java e introdução ao Spring Framework.

**Instrutoras:** Jacqueline Oliveira e Iasmin Araújo

## 📚 Projeto do Curso

**ScreenMatch** - Uma aplicação linha de comando para streaming de filmes e séries, com foco em séries (temporadas e episódios).

## 🎯 O que você vai aprender

- Criar projetos com **Spring Boot**
- Gerenciar dependências com **Maven**
- Consumir APIs externas e desserializar JSON com **Jackson**
- Usar **funções lambda** e a **API de Streams**
- Trabalhar com **Generics**, **Optional** e **API de datas**
- Gerar estatísticas com `Collectors`

## 📖 Estrutura do Curso

| Aula | Tema                                             |
| ---- | ------------------------------------------------ |
| 01   | Um novo projeto utilizando o Spring Framework    |
| 02   | Modelando os dados da aplicação                  |
| 03   | Manipulando com fluxos as coleções de dados      |
| 04   | Explorando mais os fluxos e gerando estatísticas |
| 05   | Consolidando conhecimentos (Desafio final)       |

## ✅ Evolução por Módulo

### Módulo 1: Um novo projeto utilizando o Spring Framework

Neste módulo, mergulhamos na base do ecossistema Spring e Java moderno:

- **Estrutura de um Projeto Spring**: Compreensão de pacotes, classes de configuração e o ciclo de vida do método `run`.
- **Inferência de tipos**: Aplicação prática do `var` para reduzir a verbosidade do código.
- **Consumo de API**: Implementação de clientes para requisições HTTP e tratamento de respostas JSON.
- **Modularização**: Organização do código em camadas para facilitar a manutenção.
- **Serialização e Desserialização**: Uso do **Jackson** para mapear JSON para classes Java (POJOs/Records).
- **Generics**: Implementação de interfaces e métodos genéricos para conversão de dados flexível.
- **Maven**: Gerenciamento de dependências e configuração do `pom.xml`.

### Módulo 2: Modelando os dados da aplicação

Evoluímos o projeto para uma aplicação mais robusta e interativa:

- **Anotações Jackson**: Uso avançado de `@JsonAlias` para mapear campos da API com nomes diferentes dos Java e `@JsonIgnoreProperties` para limpeza de dados.
- **Interação com Usuário**: Desenvolvimento de menus via console para capturar entradas de pesquisa.
- **Consultas Detalhadas**: Refinamento da lógica para consultar temporadas e episódios específicos.
- **Manipulação de Strings**: Formatação dinâmica de URLs para consultas parametrizadas na API.
- **Introdução aos Lambdas**: Primeiras implementações de funções anônimas para simplificar comportamentos.
- **Desenvolvimento Colaborativo**: Reflexão sobre padrões de projeto e versionamento com Git.

### Módulo 3: Manipulando com fluxos as coleções de dados

Aprofundamos no poder da **API de Streams** para manipulação declarativa de dados:

- **Stream Pipeline**: Compreensão do fluxo de dados (Fonte -> Operações Intermediárias -> Operação Final).
- **Operações Intermediárias**: Uso de `filter`, `map`, `sorted`, `limit`, `distinct` e `flatMap` para transformar e filtrar coleções.
- **Lazy Evaluation**: Entendimento de que as streams são processadas de forma sob demanda para otimização de performance.
- **Operações Finais**: Aplicação de `collect(Collectors.toList())`, `forEach`, `count` e outras para encerrar o fluxo.
- **Imutabilidade**: Prática de manipulação de coleções sem alterar a fonte original dos dados.
- **Métodos de Referência (Method Reference)**: Uso de `System.out::println` e construtores para tornar o código mais limpo.

## 🔗 Links

- [Curso na Alura](https://www.alura.com.br/) _(acesso requer assinatura)_

## 📁 Estrutura

```
├── .agent/          # Configurações do tutor
├── .metadocs/       # Plano de estudos
└── src/             # Código do ScreenMatch
```

## ⚠️ Pré-requisitos

- Formação **Java com Orientação a Objetos** concluída
