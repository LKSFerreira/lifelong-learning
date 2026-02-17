---
description: Inicialização do Ambiente de Estudos
---

Atue como um **Tutor Pedagógico** configurando o ambiente de estudos.

> [!NOTE]
> Este workflow é executado **apenas uma vez** ao iniciar um novo projeto de estudos.

## Estrutura de Diretórios

O ambiente de estudos segue esta estrutura:

```
.agent/
├── rules/
│   ├── agents.md          # Regras do Tutor
│   └── <linguagem>.md     # Convenções da linguagem
└── workflows/
    └── init.md            # Este arquivo

.metadocs/
└── roadmap.md             # Plano de estudos

README.md                  # Visão geral do curso
```

## Passos de Inicialização

### Passo 1: Identificar a Linguagem de Estudo

Pergunte ao aluno qual linguagem será estudada ou identifique pelo contexto do curso.

| Curso contém...         | Linguagem  |
| ----------------------- | ---------- |
| Java, Spring, Maven     | java       |
| Python, Django, Flask   | python     |
| JavaScript, Node, React | javascript |
| Go, Golang              | go         |

### Passo 2: Configurar agents.md

Abra `.agent/rules/agents.md` e atualize o campo:

```markdown
> LINGUAGEM_PROJETO: java
```

### Passo 3: Criar Regras da Linguagem

Se não existir `.agent/rules/<linguagem>.md`, crie com:

- Convenções de nomenclatura
- Estrutura de arquivos típica
- Comandos comuns de compilação/execução

### Passo 4: Criar Plano de Estudos

Crie `.metadocs/roadmap.md` com:

- Objetivos do curso
- Tópicos a serem estudados
- Checkboxes para acompanhamento

### Passo 5: Criar README.md

Crie um `README.md` com:

- Nome do curso
- Breve descrição
- Link para o curso original (se aplicável)

---

## Resultado Esperado

Após este workflow:

- [ ] Campo `LINGUAGEM_PROJETO` preenchido
- [ ] Arquivo de regras da linguagem existe
- [ ] Plano de estudos criado em `.metadocs/roadmap.md`
- [ ] `README.md` com informações do curso

---

> **Próximo passo:** Se precisar de um ambiente isolado, execute `/devcontainers`.
