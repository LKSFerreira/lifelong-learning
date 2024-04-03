import java.util.HashSet;
import java.util.Set;

import models.Carro;

public class UsoSet {
    public static void main(String[] args) {
        // Principais métodos da classe Set e suas aplicabilidades
        Set<Carro> setCarros = new HashSet<Carro>();

        // Adiciona elementos no set
        setCarros.add(new Carro("Ford"));
        setCarros.add(new Carro("Chevrolet"));
        setCarros.add(new Carro("Fiat"));
        setCarros.add(new Carro("Peugeot"));
        setCarros.add(new Carro("Renault"));
        setCarros.add(new Carro("Zip"));
        setCarros.add(new Carro("Alpha Romeo"));

        System.out.println("Exemplo de set: " + setCarros);

        System.out.println("----------------------------------------");

        // Remove o elemento informado
        System.out.println(setCarros.remove(new Carro("Chevrolet")));

        System.out.println("----------------------------------------");

        // Verifica se o set contém o elemento informado
        System.out.println("Retorna true se o set contém o elemento informado: " + setCarros.contains(new Carro("Fiat")));

        System.out.println("----------------------------------------");

        // Verifica se o set está vazio
        System.out.println("Retorna true se o set estiver vazio: " + setCarros.isEmpty());

        // Retorna o tamanho do set
        System.out.println("Retorna o tamanho do set: " + setCarros.size());

        System.out.println("----------------------------------------");


        // O método iterator() retorna um Iterator que permite percorrer todos os elementos do set
        System.out.println(setCarros.iterator().next());

    }
}
