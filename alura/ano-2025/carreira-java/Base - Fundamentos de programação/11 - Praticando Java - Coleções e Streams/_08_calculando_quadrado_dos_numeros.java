import java.util.List;

public class _08_calculando_quadrado_dos_numeros {
    public static void main(String[] args) {
        // Cria a lista contendo os números fornecidos
        List<Integer> numeros = List.of(2, 3, 5, 7, 11);

        // Calcula o quadrado de cada número utilizando o método map
        // map() transforma cada elemento no seu quadrado
        // toList() coleta os resultados em uma lista imutável
        List<Integer> quadrados = numeros.stream()
                .map(numero -> numero * numero)
                .toList();

        // Exibe a lista de quadrados no console
        System.out.println("Quadrados dos números: " + quadrados);
    }
}
