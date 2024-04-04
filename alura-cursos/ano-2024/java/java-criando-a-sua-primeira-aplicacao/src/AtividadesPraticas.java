import java.util.Scanner;

public class AtividadesPraticas {
    public static void main(String[] args) {
        // Número possitivo ou negativo
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nDigite um número: ");
        int numero = scanner.nextInt();

        if (numero > 0) {
            System.out.println("O número " + numero + " é positivo!");
        } else {
            System.out.println("O número " + numero + " é negativo!");
        }

        // Comparação entre dois números
        System.out.println("\nDigite o primeiro número: ");
        int numero1 = scanner.nextInt();
        System.out.println("Digite o segundo número: ");
        int numero2 = scanner.nextInt();

        if (numero1 > numero2) {
            System.out.println("O número " + numero1 + " é maior que o número " + numero2);
        } else if (numero1 < numero2) {
            System.out.println("O número " + numero2 + " é maior que o número " + numero1);
        } else {
            System.out.println("Os números são iguais!");
        }

        int menu = 0;
        while (menu != 0) {
            System.out.println("\nMenu para calcular área: ");
            System.out.println("1 - Calcular área do quadrado ou retângulo");
            System.out.println("2 - Calcular área do triângulo");
            System.out.println("3 - Calcular área do círculo");
            System.out.println("0 - Sair");

            menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("\nDigite a base do quadrado ou retângulo: ");
                    double base = scanner.nextDouble();
                    System.out.println("Digite a altura do quadrado ou retângulo: ");
                    double altura = scanner.nextDouble();
                    double areaQuadradoRetangulo = base * altura;
                    System.out.println("A área do quadrado ou retângulo é: " + areaQuadradoRetangulo);
                    break;
                case 2:
                    System.out.println("\nDigite a base do triângulo: ");
                    double baseTriangulo = scanner.nextDouble();
                    System.out.println("Digite a altura do triângulo: ");
                    double alturaTriangulo = scanner.nextDouble();
                    double areaTriangulo = (baseTriangulo * alturaTriangulo) / 2;
                    System.out.println("A área do triângulo é: " + areaTriangulo);
                    break;
                case 3:
                    System.out.println("\nDigite o raio do círculo: ");
                    double raio = scanner.nextDouble();
                    double areaCirculo = Math.PI * Math.pow(raio, 2);
                    System.out.println("A área do círculo é: " + areaCirculo);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        // Tabuada
        System.out.println("\n Digite um número para demonstrar a tabuada: ");
        int numeroTabuada = scanner.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.println(numeroTabuada + " x " + i + " = " + (numeroTabuada * i));
        }

        // Número par ou ímpar
        System.out.println("\nDigite um número para verificar se é par ou ímpar: ");
        int numeroParImpar = scanner.nextInt();

        if (numeroParImpar % 2 == 0) {
            System.out.println("O número " + numeroParImpar + " é par!");
        } else {
            System.out.println("O número " + numeroParImpar + " é ímpar!");
        }

        // Calculando fatorial
        System.out.println("\nDigite um número para calcular o fatorial: ");
        int numeroFatorial = scanner.nextInt();
        long fatorial = 1;

        for (int i = 1; i <= numeroFatorial; i++) {
            fatorial *= i;
        }

        System.out.println("O fatorial de " + numeroFatorial + " é: " + String.format("%,d", fatorial));

        scanner.close();
    }
}
