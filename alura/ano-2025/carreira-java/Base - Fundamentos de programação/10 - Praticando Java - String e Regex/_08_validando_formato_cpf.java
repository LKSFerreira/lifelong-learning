public class _08_validando_formato_cpf {
        public static void main(String[] args) {
        // Variável com o CPF
        String cpf = "123.456.789-09";
        
        // Valida o formato do CPF usando regex
        // Formato: XXX.XXX.XXX-XX
        // \\d{3} = exatamente 3 dígitos
        // \\. = ponto literal (escapado)
        // \\d{2} = exatamente 2 dígitos
        // - = hífen literal
        if (cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            System.out.println("O CPF " + cpf + " está no formato válido.");
        } else {
            System.out.println("O CPF " + cpf + " está no formato inválido.");
        }
    }

}
