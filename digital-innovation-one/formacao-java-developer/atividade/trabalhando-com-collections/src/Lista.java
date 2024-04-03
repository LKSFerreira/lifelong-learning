import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import models.Gato;

public class Lista {
    public static void main(String[] args) throws Exception {
        // Elementos duplicados são permitidos
        // Garantem a ordem de inserção

        // ArrayList deve ser utulizado quando muitas operações de pesquisa forem
        // necessárias
        // LinkedList deve ser utilizado quando muitas operações de inserção e remoção
        // forem necessárias

        // ArrayList utiliza por abstração um array para armazenar os elementos
        // LinkedList utiliza por abstração uma lista duplamente encadeada para
        // armazenar os elementos

        // ArrayList implementa apenas a interface List
        // LinkedList implementa as interfaces List e Queue

        // Formas de inicializar um ArrayList
        List notas1 = new ArrayList<>();
        List<Double> notas2 = new ArrayList<>();
        ArrayList<Double> notas3 = new ArrayList<>();
        ArrayList<Double> notas4 = new ArrayList<>(20); // Define o tamanho inicial do array interno
        List<Double> notas5 = new ArrayList<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        List<Double> notas6 = Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6); // Retorna um ArrayList imutável
        List<Double> notas7 = List.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6); // Retorna um ArrayList imutável

        // Exercício: Crie uma lista de notas e adicione 7 notas
        List<Double> notas = new ArrayList<>();
        notas.add(7.0);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5.0);
        notas.add(7.0);
        notas.add(0.0);
        notas.add(3.6);

        System.out.println(notas);

        // Exercício: Exiba a posição da nota 5.0
        System.out.println("Posição da nota 5.0: " + notas.indexOf(5.0));

        // Exercício: Adicione na lista a nota 8.0 na posição 4
        notas.add(4, 8.0);
        System.out.println(notas);

        // Exercício: Substitua a nota 5.0 pela nota 6.0
        notas.set(notas.indexOf(5.0), 6.0);

        // Exercício: Confira se a nota 5.0 está na lista
        System.out.println("A nota 5.0 está na lista? " + notas.contains(5.0));

        // Exercício: Exiba todas as notas na ordem em que foram informados
        for (Double nota : notas) {
            System.out.println(nota);
        }

        // Exercício: Exiba a terceira nota adicionada
        System.out.println("Terceira nota adicionada: " + notas.get(2));

        // Exercício: Exiba a menor nota
        System.out.println("Menor nota: " + Collections.min(notas));

        // Exercício: Exiba a maior nota
        System.out.println("Maior nota: " + Collections.max(notas));

        // Exercício: Exiba a soma dos valores

        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0;
        while (iterator.hasNext()) {
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("Soma das notas: " + soma);

        // Exercício: Exiba a média das notas
        System.out.println("Média das notas: " + soma / notas.size());

        // Exercício: Remova a nota 0.0
        notas.remove(0.0);

        // Exercício: Remova a nota da posição 0
        notas.remove(0);

        // Exercício: Remova as notas menores que 7 e exiba a lista
        Iterator<Double> iteratorRemove = notas.iterator();
        while (iteratorRemove.hasNext()) {
            Double next = iteratorRemove.next();
            if (next < 7) {
                iteratorRemove.remove();
            }
        }
        System.out.println(notas);

        // Exercício: Apague toda a lista
        notas.clear();

        // Exercício: Confira se a lista está vazia
        System.out.println("A lista está vazia? " + notas.isEmpty());

        System.out.println("===============================================");

        // Exercício: Crie uma lista de gatos e adicione 3 gatos
        List<Gato> gatos = new ArrayList<>() {
            {
                add(new Gato("Jon", 18, "preto"));
                add(new Gato("Simba", 6, "tigrado"));
                add(new Gato("Jon", 12, "amarelo"));
            }
        };

        // Exercício: Ordene a lista por ordem de inserção
        System.out.println("Ordem de inserção:");
        gatos.forEach(System.out::println);

        // Exercício: imprima a lista de gatos em ordem aleatória
        Collections.shuffle(gatos);
        System.out.println("Ordem aleatória:");
        gatos.forEach(System.out::println);

        // Exercício: Ordene a lista por ordem natural (nome)
        Collections.sort(gatos);
        System.out.println("Ordem natural (nome):" + gatos);

        // Exercício: Ordene a lista por idade - interface Comparator
        Collections.sort(gatos, new ComparatorIdade());
        System.out.println("Ordem natural (idade):");
        gatos.forEach(System.out::println);

        System.out.println("--------------------------");

        gatos.sort(new ComparatorIdade());
        System.out.println("Ordem natural (idade):");
        gatos.forEach(System.out::println);

        System.out.println("--------------------------");

        gatos.sort(new ComparableCor());



    }

}

class ComparatorIdade implements Comparator<Gato> {
    @Override
    public int compare(Gato umGato, Gato outroGato) {
        return Integer.compare(umGato.getIdade(), outroGato.getIdade());
    }

}

class ComparableCor implements Comparator<Gato> {
    @Override
    public int compare(Gato umGato, Gato outroGato) {
        return umGato.getCor().compareToIgnoreCase(outroGato.getCor());
    }
}

class ComparatorNomeCorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato umGato, Gato outroGato) {
        int nome = umGato.getNome().compareToIgnoreCase(outroGato.getNome());
        if (nome != 0) {
            return nome;
        }
        int cor = umGato.getCor().compareToIgnoreCase(outroGato.getCor());
        if (cor != 0) {
            return cor;
        }
        return Integer.compare(umGato.getIdade(), outroGato.getIdade());
    }

}
