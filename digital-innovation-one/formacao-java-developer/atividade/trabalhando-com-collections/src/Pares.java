import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Pares {
    public static void main(String[] args) {
        // Na interface MAP temos elementos únicos para KEY para cada valor.
        // O valor pode ser duplicado, mas a chave não.

        // Hashtable é thead-safe, ou seja, é sincronizado, porém é mais lento

        // TreeMap é ordenado pela chave, ou seja, a chave deve implementar a interface Comparable

        // Em relação ao Big O Notation, tanto o HashMap quanto o LinkedHashMap possuem complexidade O(1) para busca, inserção e remoção
        // Já o TreeMap possui complexidade O(log n) para busca, inserção e remoção

        // A ordem de iterção do HashMap não é garantida, já a ordem de iteração do LinkedHashMap é garantida pela ordem de inserção
        // A ordem de iteração do TreeMap é garantida pela ordem natural das chaves ou pela ordem definida no construtor

        // Chaves nulas são permitidas em HashMap e LinkedHashMap, porém não são permitidas em TreeMap

        // Exercício: Crie um dicionário que relacione os modelos e seus respectivos consumos
        Map<String, Double> carrosPopulares = new HashMap<>();
        carrosPopulares.put("gol", 13.4);
        carrosPopulares.put("uno", 15.6);
        carrosPopulares.put("mobi", 16.1);
        carrosPopulares.put("hb20", 14.5);
        carrosPopulares.put("kwid", 15.6);

        System.out.println(carrosPopulares);

        System.out.println("Substitua o consumo do gol por 15.2 km/l: " + carrosPopulares.put("gol", 16.1));
        
        System.out.println("Confira se o modelo tucson está no dicionário: " + carrosPopulares.containsKey("tucson"));

        System.out.println("Exiba o consumo do uno: " + carrosPopulares.get("uno"));

        System.out.println("Exiba o terceiro modelo adicionado: Não é possível garantir a ordem de inserção em um HashMap");

        System.out.println("Exiba os modelos: " + carrosPopulares.keySet());

        System.out.println("Exiba os consumos dos carros: " + carrosPopulares.values());

        var consumoMaisEficiente = Collections.max(carrosPopulares.values());
        var entries = carrosPopulares.entrySet();

        String modeloMaisEficiente = "";
        for (var entry : entries) {
            if (entry.getValue().equals(consumoMaisEficiente)) {
                modeloMaisEficiente = entry.getKey();
                System.out.println("O modelo mais eficiente é: " + modeloMaisEficiente + " - " + consumoMaisEficiente);
            }
        }

        var consumoMenosEficiente = Collections.min(carrosPopulares.values());
        entries = carrosPopulares.entrySet();

        String modeloMenosEficiente = "";
        for (var entry : entries) {
            if (entry.getValue().equals(consumoMenosEficiente)) {
                modeloMenosEficiente = entry.getKey();
                System.out.println("O modelo menos eficiente é: " + modeloMenosEficiente + " - " + consumoMenosEficiente);
            }
        }

        System.out.println("Exiba a soma dos consumos: " + carrosPopulares.values().stream().mapToDouble(Double::doubleValue).sum());

        // Ou podemos fazer manualmente com o interator

        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0.0;
        while (iterator.hasNext()) {
            Double next = iterator.next();
            soma += next;
        }

        System.out.println("Exiba a média dos consumos deste dicionário de carros: " + soma / carrosPopulares.size());

        System.out.println("Remova os modelos com o consumo igual a 15.6 km/l: " + carrosPopulares.values().removeIf(aDouble -> aDouble.equals(15.6)));

        // Ou podemos fazer manualmente com o interator
        iterator = carrosPopulares.values().iterator();
        while (iterator.hasNext()) {
            Double next = iterator.next();
            if (next.equals(15.6)) {
                iterator.remove();
            }
        }

        System.out.println("Exiba todos os carros na ordem em que foram informados: Não é possível garantir a ordem de inserção em um HashMap");
        System.out.println("Mas podemos usar um LinkedHashMap para garantir a ordem de inserção");

        Map<String, Double> carrosPopularesLinked = new LinkedHashMap<>();
        carrosPopularesLinked.put("gol", 13.4);
        carrosPopularesLinked.put("uno", 15.6);
        carrosPopularesLinked.put("mobi", 16.1);
        carrosPopularesLinked.put("hb20", 14.5);
        carrosPopularesLinked.put("kwid", 15.6);

        System.out.println(carrosPopularesLinked);

        System.out.println("Exiba o dicionário ordenado pelo modelo: Não é possível ordenar um HashMap");
        System.out.println("Mas podemos usar um TreeMap para garantir a ordem natural das chaves");

        Map<String, Double> carrosPopularesTree = new TreeMap<>(carrosPopularesLinked);
        System.out.println(carrosPopularesTree);

        carrosPopularesTree.clear();

        System.out.println("Confira se o dicionário está vazio: " + carrosPopularesTree.isEmpty());

      }
}
