import java.util.Stack;

import models.Carro;

public class UsoStack {
    
    public static void main(String[] args) throws Exception {
        // Principais métodos da classe Stack e suas aplicabilidades
        Stack<Carro> stackCarros = new Stack<Carro>();

        // Adiciona elementos na pilha
        stackCarros.push(new Carro("Ford"));
        stackCarros.push(new Carro("Chevrolet"));
        stackCarros.push(new Carro("Fiat"));
        System.out.println("Exemplo de pilha: " + stackCarros);

        System.out.println("----------------------------------------");

        // Remove o último elemento da pilha
        System.out.println(stackCarros.pop());
        System.out.println("Remove último elemento da pilha: " + stackCarros);
        
        System.out.println("----------------------------------------");
        // Retorna o último elemento da pilha
        System.out.println(stackCarros.peek());
        System.out.println("Retornao o último elemento da pilha: " + stackCarros);
        
        System.out.println("----------------------------------------");
        System.out.println("O método search() retorna a posição do elemento na pilha, caso não encontre retorna -1");
        System.out.println(stackCarros.search(new Carro("Ford")));
        System.out.println(stackCarros.search(new Carro("Chevrolet")));
        System.out.println(stackCarros.search(new Carro("Fiat")));

        System.out.println("----------------------------------------");

        // Verifica se a pilha está vazia
        System.out.println("Retorna true se a pilha estiver vazia: " + stackCarros.empty());

        // Retorna o tamanho da pilha
        System.out.println("Retorna o tamanho da pilha: " + stackCarros.size());

        System.out.println("----------------------------------------");

        // Retorna o elemento da posição informada
        System.out.println("O meétodo elementAt() retorna o elemento da posição informada");
        System.out.println(stackCarros.elementAt(0));
        System.out.println(stackCarros.elementAt(1));

      
        System.out.println("----------------------------------------");

        // Retorna o elemento da posição informada
        System.out.println("O meétodo get() retorna o elemento da posição informada");
        System.out.println(stackCarros.get(0));
        System.out.println(stackCarros.get(1));

        System.out.println("----------------------------------------");

        // Retorna o primeiro elemento da pilha
        System.out.println("Retorna o primeiro elemento da pilha: " + stackCarros.firstElement());

        // Retorna o ultimo elemento da pilha
        System.out.println("Retorna o último elemento da pilha: " + stackCarros.lastElement());


    }
}
