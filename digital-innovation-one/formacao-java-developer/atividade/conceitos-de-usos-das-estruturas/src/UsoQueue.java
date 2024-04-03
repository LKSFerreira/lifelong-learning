import java.util.LinkedList;
import java.util.Queue;

import models.Carro;

public class UsoQueue {
    public static void main(String[] args) {
        // Principais métodos da classe Queue e suas aplicabilidades
        Queue<Carro> queueCarros = new LinkedList<Carro>();

        // Adiciona elementos na fila
        queueCarros.add(new Carro("Ford"));
        queueCarros.add(new Carro("Chevrolet"));
        queueCarros.add(new Carro("Fiat"));
        System.out.println("Exemplo de fila: " + queueCarros);

        System.out.println("----------------------------------------");

        // Remove o primeiro elemento da fila
        System.out.println(queueCarros.remove());
        System.out.println("Remove primeiro elemento da fila: " + queueCarros);

        System.out.println("----------------------------------------");

        // Retorna o primeiro elemento da fila
        System.out.println(queueCarros.peek());
        System.out.println("Retorna o primeiro elemento da fila sem remover: " + queueCarros);

        System.out.println("----------------------------------------");

        // Retorna o primeiro elemento da fila
        System.out.println(queueCarros.element());
        System.out.println("Retorna o primeiro elemento da fila sem remove: " + queueCarros);

        System.out.println("----------------------------------------");

        // Verifica se a fila está vazia
        System.out.println("Retorna true se a fila estiver vazia: " + queueCarros.isEmpty());

        // Retorna o tamanho da fila
        System.out.println("Retorna o tamanho da fila: " + queueCarros.size());

        System.out.println("----------------------------------------");

        // Adiciona um elemento na fila e retorna true se a operação foi bem sucedida
        System.out.println("Retorna true se a operação foi bem sucedida: " + queueCarros.offer(new Carro("Renault")));
        System.out.println("Adiciona um elemento na fila: " + queueCarros);

        System.out.println("----------------------------------------");

        // O método poll() retorna o primeiro elemento da fila e o remove
        System.out.println(queueCarros.poll());
        System.out.println("Retorna o primeiro elemento da fila e o remove: " + queueCarros);

       
        

    }
}
