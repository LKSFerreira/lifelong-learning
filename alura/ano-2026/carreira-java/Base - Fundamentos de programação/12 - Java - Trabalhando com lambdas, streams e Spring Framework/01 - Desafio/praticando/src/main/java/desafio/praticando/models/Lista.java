package desafio.praticando.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lista {
    private static List<Integer> numeros = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    private static List<String> linguagensDeProgramacao = new ArrayList<>(Arrays.asList("Python", "Ruby", "C++", "Java", "JavaScript", "VisualBasic", "PHP", "Lua", "Assembly"));

    public static void executar (){
        System.out.println("List de multiplicação por 3:\n");
        getNumeros().replaceAll(numero -> numero * 3);
        numeros.forEach(System.out::println);

        System.out.println("=====================================================");
        System.out.println("Nomes de Linguagem de Programação em ordem alfabética:\n");
        getLinguagensDeProgramacao().sort(Comparator.naturalOrder());
        getLinguagensDeProgramacao().forEach(System.out::println);
        System.out.println();
    }


    private static List<Integer> getNumeros() {
        return numeros;
    }


    public static List<String> getLinguagensDeProgramacao() {
        return linguagensDeProgramacao;
    }

    

}
