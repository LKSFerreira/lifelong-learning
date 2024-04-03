import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import models.Serie;

public class Conjunto {
    public static void main(String[] args) {
        // Não permite elementos duplicados
        // Não garante ordem de inserção
        // Não é indexado, ou seja, não possui nenhum método relacionado a índice ou posição, por exemplo, get(int index)
        // Temos o treeSet, LinkedHashSet e HashSet

        // HashSet utiliza a implementação HashMap
        // LinkedHashSet utiliza a implementação LinkedHashMap
        // TreeSet utiliza a implementação TreeMap

        // HashSet não garante ordem de inserção, ou seja, elementos podem ser exibidos em ordem aleatória
        // LinkedHashSet garante ordem de inserção, ou seja, elementos são exibidos na ordem em que foram adicionados
        // TreeSet garante ordem natural, ou seja, elementos são exibidos na ordem natural dos elementos (ordem alfabética, por exemplo)

        // Em questão de performance, HashSet é mais rápido que LinkedHashSet, que é mais rápido que TreeSet
        // Tanto o HashSet quanto o LinkedHashSet permitem elementos apenas de um único elemento null, o TreeSet não permite nenhum elemento null

        // Exercício: Crie um conjunto e adicione as notas
        Set<Double> notas = new HashSet<>();
        notas.add(7.0);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5.0);
        notas.add(7.0);
        notas.add(0.0);
        notas.add(3.6);

        System.out.println(notas);

        // Exercício: Exiba a posição da nota 5.0
        System.out.println("Não é possível exibir a posição de um elemento em um conjunto");

        // Exercício: Adicione no conjunto a nota 8.0 na posição 4
        System.out.println("Não é possível adicionar um elemento em uma posição específica em um conjunto");

        // Exercício: Substitua a nota 5.0 pela nota 6.0
        System.out.println("Não é possível substituir um elemento em um conjunto");

        // Exercício: Confira se a nota 5.0 está no conjunto
        System.out.println("A nota 5.0 está na lista? " + notas.contains(5.0));

        // Exercício: Exiba a terceira nota adicionada
        System.out.println("Não é possível exibir os elementos de um conjunto na ordem em que foram informados");

        // Exercício: Exiba a menor nota
        System.out.println("Exiba a menor nota: " + Collections.min(notas));

        // Exiba a maior nota
        System.out.println("Exiba a maior nota: " + Collections.max(notas));

        // Exercício: Exiba a soma dos valores

        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0;
        while (iterator.hasNext()) {
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("Soma das notas: " + soma);

        // Exercício: Exiba a média das notas
        System.out.println("Exiba a média das notas: " + soma / notas.size());

        // Exercício: Remova a nota 0.0
        notas.remove(0.0);

        // Exercício: Remova a nota da posição 0
        System.out.println("Não é possível remover um elemento de uma posição específica em um conjunto");

        // Exercício: Remova as notas menores que 7 e exiba o conjunto
        System.out.print("Removendo todas as notas menores que 7: ");

        while (iterator.hasNext()) {
            Double next = iterator.next();
            if (next < 7.0) {
                notas.remove(next);
            }
        }
        System.out.println(notas);

        // Usando linkedHashSet
        // Exercício: Exiba todas as notas na ordem em que foram informados
        Set<Double> notasLinkedHashSet = notas;
        System.out.println("Exiba todas as notas na ordem em que foram informados: " + notasLinkedHashSet);

        // Usando TreeSet
        // Exercício: Exiba todas as notas na ordem crescente
        Set<Double> notasTreeSet = new TreeSet<>(notas);
        System.out.println("Exiba todas as notas na ordem crescente: " + notasTreeSet);

        // Exercício: Apague todo o conjunto
        notas.clear();

        // Exercício: Confira se o conjunto está vazio
        System.out.println("Confira se o conjunto está vazio: " + notas.isEmpty());

        System.out.println("===============================================");

        // Adicione serie a um hashSet
        Set<Serie> minhasSeries = new HashSet<>();

        minhasSeries.add(new Serie("GoT", "Fantasia", 60));
        minhasSeries.add(new Serie("Dark", "Drama", 60));
        minhasSeries.add(new Serie("That 70's Show", "Comédia", 25));
        minhasSeries.add(new Serie("The Walking Dead", "Drama", 45));
        minhasSeries.add(new Serie("The Big Bang Theory", "Comédia", 25));
        

        minhasSeries.forEach(System.out::println);
        
        System.out.println("===============================================");
        
        // Por ordem de inserção
        minhasSeries = new LinkedHashSet<>(){{
            add(new Serie("GoT", "Fantasia", 60));
            add(new Serie("Dark", "Drama", 60));
            add(new Serie("That 70's Show", "Comédia", 25));
            add(new Serie("The Walking Dead", "Drama", 45));
            add(new Serie("The Big Bang Theory", "Comédia", 25));
        }};
    
        minhasSeries.forEach(System.out::println);

        System.out.println("===============================================");

        minhasSeries = new TreeSet<>(minhasSeries);
        minhasSeries.forEach(System.out::println);
        
        
    }
}
