public class condicionais_if_else {
    public static void main(String[] args) {
        // Estruturas condicionais em Java: if, else if, else

        System.out.println("\n=== Estruturas Condicionais ===\n");

        int idade = 20;
        boolean estudante = true;

        // Exemplo 1: Estrutura if simples
        if (idade >= 18) {
            System.out.println("Você é maior de idade.");
        }

        // Exemplo 2: Estrutura if-else
        if (idade < 18) {
            System.out.println("Você é menor de idade.");
        } else {
            System.out.println("Você é maior de idade.");
        }

        // Exemplo 3: Estrutura if-else if-else
        if (idade < 12) {
            System.out.println("Criança");
        } else if (idade >= 12 && idade < 18) {
            System.out.println("Adolescente");
        } else if (idade >= 18 && idade < 65) {
            System.out.println("Adulto");
        } else {
            System.out.println("Idoso");
        }

        // Exemplo 4: Uso de operadores lógicos
        if (idade >= 18 && estudante) {
            System.out.println("Você é um estudante maior de idade.");
        } else if (idade < 18 && estudante) {
            System.out.println("Você é um estudante menor de idade.");
        } else {
            System.out.println("Você não é um estudante.");
        }

        // Exemplo 5: Aninhamento de estruturas condicionais
        if (idade >= 18) {
            if (estudante) {
                System.out.println("Você é um estudante maior de idade.");
            } else {
                System.out.println("Você é um adulto não estudante.");
            }
        } else {
            if (estudante) {
                System.out.println("Você é um estudante menor de idade.");
            } else {
                System.out.println("Você é uma criança ou adolescente não estudante.");
            }
        }

        // Observação: Sempre use chaves {} para delimitar blocos de código, mesmo que haja apenas uma linha dentro do bloco. Isso melhora a legibilidade e evita erros futuros.


        System.out.println("=== Usando condicionais ternárias ===\n");

        //

        // Exemplo 6: Uso de operador ternário
        String categoria = (idade < 18) ? "Menor de idade" : "Maior de idade";
        System.out.println("Categoria: " + categoria);


    }
}
