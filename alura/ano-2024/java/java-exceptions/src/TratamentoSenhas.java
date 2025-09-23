import java.util.Scanner;

import exceptions.SenhaInvalidaException;

public class TratamentoSenhas {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDigite uma senha: ");

        try {
            String senha = scanner.nextLine();

            if (senha.length() < 8) {
                throw new SenhaInvalidaException("A senha deve ter no mínimo 8 caracteres.");
            }

            if (senha.length() > 12) {
                throw new SenhaInvalidaException("A senha deve ter no máximo 12 caracteres.");
            }

            if (!senha.matches(".*\\d.*")) {
                throw new SenhaInvalidaException("A senha deve conter ao menos um número.");
            }

            if (!senha.matches(".*[A-Z].*")) {
                throw new SenhaInvalidaException("A senha deve conter ao menos uma letra maiúscula.");
            }

            if (!senha.matches(".*[a-z].*")) {
                throw new SenhaInvalidaException("A senha deve conter ao menos uma letra minúscula.");
            }

            if (senha.matches(".*[#-'\"].*")) {
                throw new SenhaInvalidaException("A senha não deve conter os caracteres #, -, \", '");
            }

            if (!senha.matches(".*[!@$%^&*()+].*")) {
                throw new SenhaInvalidaException("A senha deve conter ao menos um caractere especial.");
            }

            if (senha.matches(".*\\s.*")) {
                throw new SenhaInvalidaException("A senha não deve conter espaços.");
            }

            System.out.println("Senha válida.");
        } catch (SenhaInvalidaException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }

        System.out.println("Fim do programa");
    }
}
