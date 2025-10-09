public class variraveis_e_tipos {
    public static void main(String[] args) {
        // Tipos de variáveis em Java

        // Existem 2 tipos principais de variáveis em Java:
        // 1. Tipos primitivos (8 tipos)
        // 2. Tipos de referência (objetos)

        // Tipos primitivos:

        System.out.println("\n=== Tipos Primitivos ===\n");

        // 1. byte: 8 bits, valores de -128 a 127
        byte b1 = -128;
        byte b2 = 127;
        System.out.println("Valor mínimo de um byte (negativo): " + b1);
        System.out.println("Valor máximo de um byte (positivo): " + b2);

        System.out.println();

        // 2. short: 16 bits, valores de -32.768 a 32.767
        short s1 = -32768;
        short s2 = 32767;
        System.out.println("Valor mínimo de um short (negativo): " + s1);
        System.out.println("Valor máximo de um short (positivo): " + s2);

        System.out.println();

        // 3. int: 32 bits, valores de -2.147.483.648 a 2.147.483.647
        int i1 = -2147483648;
        int i2 = 2147483647;
        System.out.println("Valor mínimo de um int (negativo): " + i1);
        System.out.println("Valor máximo de um int (positivo): " + i2);

        System.out.println();

        // 4. long: 64 bits, valores de -9.223.372.036.854.775.808 a 9.223.372.036.854.775.807
        long l1 = -9223372036854775808L;
        long l2 = 9223372036854775807L;
        System.out.println("Valor mínimo de um long (negativo): " + l1);
        System.out.println("Valor máximo de um long (positivo): " + l2);

        System.out.println();
        
        // 5. float: 32 bits, números de ponto flutuante (decimais), quantidade de casas decimais -3.4028235E38f a 3.4028235E38f
        float f1 = -3.4028235E38f;
        float f2 = 3.4028235E38f;
        System.out.println("Valor mínimo de um float (negativo): " + f1);
        System.out.println("Valor máximo de um float (positivo): " + f2);

        System.out.println();

        // 6. double: 64 bits, números de ponto flutuante (decimais), quantidade de casas decimais -1.7976931348623157E308 a 1.7976931348623157E308
        double d1 = -1.7976931348623157E308;
        double d2 = 1.7976931348623157E308;
        System.out.println("Valor mínimo de um double (negativo): " + d1);
        System.out.println("Valor máximo de um double (positivo): " + d2);

        System.out.println();

        // 7. char: 16 bits, representa um único caractere (letra, número, símbolo), valores de '\u0000' (0) a '\uffff' (65.535)
        char c1 = '\u0000';
        char c2 = '\uffff';

        System.out.println("Valor mínimo de um char (negativo): " + (int)c1);
        System.out.println("Valor máximo de um char (positivo): " + (int)c2);

        System.out.println();

        // 8. boolean: 1 bit, representa valores lógicos (true ou false)
        boolean bo1 = true;
        boolean bo2 = false;
        System.out.println("Valor booleano verdadeiro: " + bo1);
        System.out.println("Valor booleano falso: " + bo2);

        System.out.println();

        System.out.println("=== Tipos de Referência (Objetos) ===\n");

        // Tipos de referência (objetos):
        String nome = "Variáveis e Tipos em Java";
        System.out.println("Exemplo de String (objeto): " + nome);

        System.out.println();

        System.out.println("=== Classes Wrapper para Tipos Primitivos ===\n");

        Byte b3 = 100; // Classe wrapper para byte
        System.out.println("Exemplo de Byte (objeto): " + b3);
        System.out.println(b3.hashCode());

        System.out.println();
        
        Short s3 = 1000; // Classe wrapper para short
        System.out.println("Exemplo de Short (objeto): " + s3);
        System.out.println(s3.hashCode());

        System.out.println();

        Integer i3 = 10000; // Classe wrapper para int
        System.out.println("Exemplo de Integer (objeto): " + i3);
        System.out.println(i3.hashCode());

        System.out.println();

        Long l3 = 100000L; // Classe wrapper para long
        System.out.println("Exemplo de Long (objeto): " + l3);
        System.out.println(l3.hashCode());

        System.out.println();

        Float f3 = 10.5f; // Classe wrapper para float
        System.out.println("Exemplo de Float (objeto): " + f3);
        System.out.println(f3.hashCode());

        System.out.println();

        Double d3 = 20.99; // Classe wrapper para double
        System.out.println("Exemplo de Double (objeto): " + d3);
        System.out.println(d3.hashCode());

        System.out.println();

        Character c3 = 'A'; // Classe wrapper para char
        System.out.println("Exemplo de Character (objeto): " + c3);
        System.out.println(c3.hashCode());

        System.out.println();

        Boolean bo3 = true; // Classe wrapper para boolean
        System.out.println("Exemplo de Boolean (objeto): " + bo3);
        System.out.println(bo3.hashCode());

        System.out.println();

        // Observação: Classes wrapper são usadas para converter tipos primitivos em objetos, permitindo o uso de métodos e funcionalidades adicionais.
        System.out.println("Observação: Classes wrapper são usadas para converter tipos primitivos em objetos, permitindo o uso de métodos e funcionalidades adicionais.");


        




    }
}
