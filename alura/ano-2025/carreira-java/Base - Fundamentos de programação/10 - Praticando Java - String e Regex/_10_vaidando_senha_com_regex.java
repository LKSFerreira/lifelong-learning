import java.util.regex.Pattern;

public class _10_vaidando_senha_com_regex {
        public static void main(String[] args) {
        String senha = "Senha123!";
        
        // Verifica cada critério individualmente
        boolean temMaiuscula = Pattern.compile("[A-Z]").matcher(senha).find();
        boolean temMinuscula = Pattern.compile("[a-z]").matcher(senha).find();
        boolean temNumero = Pattern.compile("[0-9]").matcher(senha).find();
        boolean temEspecial = Pattern.compile("[@#$%^&+=!]").matcher(senha).find();
        boolean temTamanho = senha.length() >= 8;
        
        if (temMaiuscula && temMinuscula && temNumero && temEspecial && temTamanho) {
            System.out.println("A senha é válida.");
        } else {
            System.out.println("A senha é inválida.");
            if (!temTamanho) System.out.println("- Precisa ter pelo menos 8 caracteres");
            if (!temMaiuscula) System.out.println("- Precisa ter pelo menos uma letra maiúscula");
            if (!temMinuscula) System.out.println("- Precisa ter pelo menos uma letra minúscula");
            if (!temNumero) System.out.println("- Precisa ter pelo menos um número");
            if (!temEspecial) System.out.println("- Precisa ter pelo menos um caractere especial");
        }
    }
}
