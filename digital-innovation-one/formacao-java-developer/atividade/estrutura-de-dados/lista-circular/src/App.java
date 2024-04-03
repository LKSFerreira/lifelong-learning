import pacote.ListaCircular;

public class App {
    public static void main(String[] args) throws Exception {
        ListaCircular<String> listaCircular = new ListaCircular<>();

        System.out.println("A lista está vazia? " + listaCircular.isEmpty());

        System.out.println("---------------------------'");

        listaCircular.add("c0");
        System.out.println(listaCircular.get(0));

        System.out.println("---------------------------'");
        listaCircular.remove(0);
        System.out.println(listaCircular);

        System.out.println("---------------------------'");
        listaCircular.add("c0");
        listaCircular.add("c1");
        listaCircular.add("c2");
        listaCircular.add("c3");

        System.out.println(listaCircular);

        System.out.println("---------------------------'");

        for (int i = 0; i < 10; i++) {
            System.out.println(listaCircular.get(i));
        }

    }
}
