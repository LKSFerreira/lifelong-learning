import java.util.List;

public class _07_selecionando_funcionarios_nomes_curtos {
    public static void main(String[] args) {
        // Cria a lista de funcionários
        List<String> funcionarios = List.of("Ana", "Bruno", "Carlos", "Amanda", "Alice", "Daniel", "Caroline");

        // Filtra apenas os nomes com 5 caracteres ou menos
        // filter() verifica a condição: length() <= 5
        // toList() transforma em uma lista IMUTAVEL.
        List<String> funcionariosComNomesCurtos = funcionarios.stream()
                .filter(nome -> nome.length() <= 5)
                .toList();

        // Exibe a lista filtrada no console
        System.out.println(funcionariosComNomesCurtos);
    }
}
