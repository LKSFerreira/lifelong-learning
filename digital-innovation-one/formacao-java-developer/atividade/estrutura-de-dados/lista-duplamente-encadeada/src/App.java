import pacote.ListaDuplamenteEncadeada;

public class App {
    public static void main(String[] args) throws Exception {

        ListaDuplamenteEncadeada<String> listaDuplamenteEncadeada = new ListaDuplamenteEncadeada<>();

        System.out.println("Esta vazia? " + listaDuplamenteEncadeada.isEmpty());

        listaDuplamenteEncadeada.add("primeiro");
        listaDuplamenteEncadeada.add("segundo");
        listaDuplamenteEncadeada.add("terceiro");

        System.out.println(listaDuplamenteEncadeada.get(0));
        System.out.println(listaDuplamenteEncadeada.get(1));
        System.out.println(listaDuplamenteEncadeada.get(2));

        System.out.println("Tamanho lista " + listaDuplamenteEncadeada.size());

        listaDuplamenteEncadeada.remove(1);
        listaDuplamenteEncadeada.add(1, "9999999");
        System.out.println(listaDuplamenteEncadeada);
    }
}
