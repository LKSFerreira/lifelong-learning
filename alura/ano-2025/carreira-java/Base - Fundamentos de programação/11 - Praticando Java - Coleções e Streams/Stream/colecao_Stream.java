import java.util.List;

public class colecao_Stream {
    public static void main(String[] args) {
        List<String> nomes = List.of("LKS Ferreira", "Vanny", "iSofy", "Fulano", "Ciclano", "Beltrano", "Lucas", "Lunara");

        List<String> nomesComLetraA = nomes.stream()
            .filter(nome -> nome.startsWith("L"))
            .toList();

        System.out.println("nomes que começam com 'L': " + nomesComLetraA);
    
    }
}
