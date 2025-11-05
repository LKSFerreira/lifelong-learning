public class _07_valida_codigo_de_referencia {
    public static void main(String[] args) {
        // Variável com o código de referência
        String codigo = "ABC-1234";
        
        // Valida o código usando regex
        // Formato: 3 letras maiúsculas + hífen + 4 dígitos
        if (codigo.matches("[A-Z]{3}-\\d{4}")) {
            System.out.println("O código de referência está válido.");
        } else {
            System.out.println("O código de referência está inválido.");
        }
    }
}
