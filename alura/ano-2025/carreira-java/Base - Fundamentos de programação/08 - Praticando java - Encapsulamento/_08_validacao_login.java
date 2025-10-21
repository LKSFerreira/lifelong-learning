import java.util.Scanner;

public class _08_validacao_login {

    public static void main(String[] args) {
        Login login = new Login("aluno2025", "escola@123");
        
        try (Scanner scanner = new Scanner(System.in)) {
            while (!login.isBloqueado()) {
                System.out.print("Login: ");
                String loginDigitado = scanner.nextLine();
                
                System.out.print("Senha: ");
                String senhaDigitada = scanner.nextLine();
                
                if (login.tentarLogin(loginDigitado, senhaDigitada)) {
                    break;
                }
            }
        }
    }

    public static class Login {
        private String login;
        private String senha;
        private int tentativasRestantes = 3;
        private boolean bloqueado = false;

        public Login(String login, String senha) {
            this.login = login;
            this.senha = senha;
        }

        public boolean tentarLogin(String login, String senha) {
            if (bloqueado) {
                System.out.println("Acesso bloqueado.");
                return false;
            }

            if (this.login.equals(login) && this.senha.equals(senha)) {
                System.out.println("Login bem-sucedido!");
                return true;
            } else {
                tentativasRestantes--;
                System.out.println("Senha incorreta. Tentativas restantes: " + tentativasRestantes);
                if (tentativasRestantes == 0) {
                    bloqueado = true;
                    System.out.println("Acesso bloqueado.");
                }
                return false;
            }
        }

        public boolean isBloqueado() {
            return bloqueado;
        }
    }
}