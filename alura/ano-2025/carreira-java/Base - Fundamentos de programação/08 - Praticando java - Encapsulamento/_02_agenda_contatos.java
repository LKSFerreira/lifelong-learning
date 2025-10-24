import java.util.ArrayList;

class Contato {
    private String nome;
    private String telefone;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Contato [nome=" + nome + ", telefone=" + telefone + "]";
    }

}

public class _02_agenda_contatos {
    public static void main(String[] args) {

        ArrayList<Contato> agenda = new ArrayList<>();
        agenda.add(new Contato("Alice", "1234-5678"));
        agenda.add(new Contato("Bob", "8765-4321"));
        agenda.add(new Contato("Charlie", "5555-5555"));

        agenda.forEach(System.out::println);

    }

}