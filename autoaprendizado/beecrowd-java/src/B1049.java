import java.util.Scanner;

public class B1049 {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            String filo = scanner.nextLine();
            String classe = scanner.nextLine();
            String alimentacao = scanner.nextLine();

            switch (filo) {
                case "vertebrado":
                    switch (classe) {
                        case "ave":
                            switch (alimentacao) {
                                case "carnivoro":
                                    System.out.println("aguia");
                                    break;
                                case "onivoro":
                                    System.out.println("pomba");
                                    break;
                            }
                            break;
                        case "mamifero":
                            switch (alimentacao) {
                                case "onivoro":
                                    System.out.println("homem");
                                    break;
                                case "herbivoro":
                                    System.out.println("vaca");
                                    break;
                            }
                            break;
                    }
                    break;
                case "invertebrado":
                    switch (classe) {
                        case "inseto":
                            switch (alimentacao) {
                                case "hematofago":
                                    System.out.println("pulga");
                                    break;
                                case "herbivoro":
                                    System.out.println("lagarta");
                                    break;
                            }
                            break;
                        case "anelideo":
                            switch (alimentacao) {
                                case "hematofago":
                                    System.out.println("sanguessuga");
                                    break;
                                case "onivoro":
                                    System.out.println("minhoca");
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }
    }
}