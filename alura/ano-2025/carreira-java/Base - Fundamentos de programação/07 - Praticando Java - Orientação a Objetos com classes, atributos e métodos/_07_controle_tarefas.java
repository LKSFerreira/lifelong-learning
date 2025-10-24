import java.util.ArrayList;
import java.util.List;

// Define a classe Tarefa
class Tarefa {
    String descricao;
    boolean concluida;

    /**
     * Mostra a descrição da tarefa e seu status (Pendente ou Concluída).
     */
    public void mostrarTarefa() {
        // Usa um operador ternário para definir a string de status
        String status = this.concluida ? "Concluída" : "Pendente";
        System.out.println("Tarefa: " + this.descricao + " - Status: " + status);
    }
}

public class _07_controle_tarefas {

    public static void main(String[] args) {
        // Cria uma lista para armazenar as tarefas
        List<Tarefa> listaDeTarefas = new ArrayList<>();

        // Cria e configura a primeira tarefa
        Tarefa t1 = new Tarefa();
        t1.descricao = "Estudar Java";
        t1.concluida = false;

        // Cria e configura a segunda tarefa
        Tarefa t2 = new Tarefa();
        t2.descricao = "Fazer exercícios";
        t2.concluida = true;

        // Adiciona as tarefas à lista
        listaDeTarefas.add(t1);
        listaDeTarefas.add(t2);

        // Itera sobre a lista e exibe cada tarefa

        // for (Tarefa tarefa : listaDeTarefas) {
        //     tarefa.mostrarTarefa();
        // }

        listaDeTarefas.forEach(Tarefa::mostrarTarefa);
    }

}
