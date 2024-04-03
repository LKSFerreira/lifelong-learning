import pacote.ListaEncadeada;

public class App {
    public static void main(String[] args) throws Exception {
        ListaEncadeada<String> minhaListaEncadeada = new ListaEncadeada<>();

        System.out.println("A lista está vazia? " + minhaListaEncadeada.isEmpty());

        minhaListaEncadeada.add("teste1");
        minhaListaEncadeada.add("teste2");
        minhaListaEncadeada.add("teste3");
        minhaListaEncadeada.add("teste4");
        
        System.out.println(minhaListaEncadeada.get(0));
        System.out.println(minhaListaEncadeada.get(1));
        System.out.println(minhaListaEncadeada.get(2));
        System.out.println(minhaListaEncadeada.get(3));
        
        System.out.println("Nó removido: " + minhaListaEncadeada.remove(3));
        System.out.println(minhaListaEncadeada);

        System.out.println("Tamanho atual da lista: " + minhaListaEncadeada.size());
        
    }
}
