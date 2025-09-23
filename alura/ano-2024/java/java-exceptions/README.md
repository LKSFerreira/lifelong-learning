# Java

## Meus Utils
```java
public static String formatJson(String json) {
    // StringBuilder para construir a versão formatada do JSON
    StringBuilder formattedJson = new StringBuilder();
    
    // Variável para rastrear o nível atual de indentação
    int indent = 0;
    
    // Flag para acompanhar quando estamos dentro de uma string
    boolean inQuote = false;

    // Itera sobre cada caractere do JSON
    for (char c : json.toCharArray()) {
        switch (c) {
            case '\"':
                // Alterna o estado de inQuote quando encontra um caractere de aspas
                // e verifica se a aspas não é precedida por uma barra invertida
                if (formattedJson.length() > 0 && formattedJson.charAt(formattedJson.length() - 1) != '\\') {
                    inQuote = !inQuote;
                }
                formattedJson.append(c);
                break;
            case '{':
            case '[':
                // Se não estiver dentro de uma string, aumenta a indentação
                if (!inQuote) {
                    formattedJson.append(c).append("\n").append(" ".repeat(indent + 2));
                    indent += 2;
                } else {
                    formattedJson.append(c);
                }
                break;
            case '}':
            case ']':
                // Se não estiver dentro de uma string, diminui a indentação
                if (!inQuote) {
                    indent -= 2;
                    formattedJson.append("\n").append(" ".repeat(indent)).append(c);
                } else {
                    formattedJson.append(c);
                }
                break;
            case ',':
                // Se não estiver dentro de uma string, adiciona uma quebra de linha após a vírgula
                if (!inQuote) {
                    formattedJson.append(c).append("\n").append(" ".repeat(indent));
                } else {
                    formattedJson.append(c);
                }
                break;
            case ':':
                // Se não estiver dentro de uma string, adiciona um espaço após o dois-pontos
                if (!inQuote) {
                    formattedJson.append(c).append(" ");
                } else {
                    formattedJson.append(c);
                }
                break;
            default:
                // Adiciona os outros caracteres normalmente
                formattedJson.append(c);
        }
    }

    // Retorna a string formatada
    return formattedJson.toString();
}
```

A lógica desse código é a seguinte:

- O código percorre cada caractere do JSON original.
- Quando encontra aspas (`"`) verifica se é o início ou fim de uma string. As strings são detectadas pelo uso de aspas que não são precedidas por uma barra invertida (indicando que não são caracteres de escape).
- Os caracteres de abertura `{` e `[` aumentam a indentação se não estiverem dentro de uma string.
- Os caracteres de fechamento `}` e `]` diminuem a indentação se não estiverem dentro de uma string.
- Após cada vírgula (`,`), se não estiver dentro de uma string, o código insere uma quebra de linha e a indentação atual.
- Após cada dois pontos (`:`), se não estiver dentro de uma string, o código insere um espaço para separar o nome do valor no par chave-valor do JSON.
- Todos os outros caracteres são adicionados ao `StringBuilder` diretamente.

Esse método simples para formatar JSON é útil para visualização em um ambiente de desenvolvimento ou para depuração, mas não substitui uma biblioteca de parse de JSON para manipulação de dados JSON em uma aplicação real.