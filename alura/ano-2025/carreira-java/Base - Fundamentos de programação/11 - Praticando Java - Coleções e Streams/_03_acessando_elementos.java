
import java.util.ArrayList;
import java.util.List;

public class _03_acessando_elementos {
    public static void main(String[] args) {
        List<String> funcionarios = new ArrayList<>();

        funcionarios.add("João");
        funcionarios.add("Maria");
        funcionarios.add("Ana");
        funcionarios.add("Pedro");
        funcionarios.add("Antônio");


        System.out.println("A segunda pessoa na lista é: " + funcionarios.get(1));
        System.out.println("Total de funcionarios: " + funcionarios.size());
    }
}
