package models;

import java.util.ArrayList;
import java.util.List;

public class UsoList {
    public static void main(String[] args) {
        // Principais métodos da classe List e suas aplicabilidades
        List<Carro> listCarros = new ArrayList<Carro>();

        // Adiciona elementos na lista
        listCarros.add(new Carro("Ford"));
        listCarros.add(new Carro("Chevrolet"));
        listCarros.add(new Carro("Fiat"));
        listCarros.add(new Carro("Peugeot"));
        System.out.println("Exemplo de lista: " + listCarros);

        System.out.println("----------------------------------------");

        // Remove o elemento da posição informada
        System.out.println(listCarros.remove(0));
        System.out.println("Remove o elemento da posição informada: " + listCarros);

        System.out.println("----------------------------------------");

        // Remove o elemento informado
        System.out.println(listCarros.remove(new Carro("Chevrolet")));
        System.out.println("Remove o elemento informado: " + listCarros);

        System.out.println("----------------------------------------");

        // Retorna o elemento da posição informada
        System.out.println(listCarros.get(0));
        System.out.println("Retorna o elemento da posição informada: " + listCarros);

        System.out.println("----------------------------------------");

        // Retorna o elemento da posição informada
        System.out.println(listCarros.indexOf(new Carro("Peugeot")));
        System.out.println("Retorna o elemento da posição informada: " + listCarros);

        System.out.println("----------------------------------------");

        // Verifica se a lista está vazia
        System.out.println("Retorna true se a lista estiver vazia: " + listCarros.isEmpty());

        // Retorna o tamanho da lista
        System.out.println("Retorna o tamanho da lista: " + listCarros.size());

        System.out.println("----------------------------------------");

        // Adiciona um elemento na lista e retorna true se a operação foi bem sucedida
        System.out.println("Retorna true se a operação foi bem sucedida: " + listCarros.add(new Carro("Renault")));
        System.out.println("Adiciona um elemento na lista: " + listCarros);

        System.out.println("----------------------------------------");

        // Adiciona um elemento na lista na posição informada
        listCarros.add(0, new Carro("Citroen"));
        System.out.println("Adiciona um elemento na lista na posição informada: " + listCarros);

        System.out.println("----------------------------------------");

        // Substitui o elemento da posição informada
        listCarros.set(0, new Carro("New Citroen"));
        System.out.println("Substitui o elemento da posição informada: " + listCarros);

        System.out.println("----------------------------------------");

        // O método contains() retorna true se o elemento informado estiver na lista
        System.out.println("Retorna true se o elemento informado estiver na lista: " + listCarros.contains(new Carro("New Citroen")));

        System.out.println("----------------------------------------");

    }
}
