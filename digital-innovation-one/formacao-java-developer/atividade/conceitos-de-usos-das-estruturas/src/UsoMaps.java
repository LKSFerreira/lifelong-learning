import java.util.HashMap;
import java.util.Map;

import models.Carro;

public class UsoMaps {
    public static void main(String[] args) {
        // Principais métodos da classe Map e suas aplicabilidades
        Map<String, Carro> mapCarros = new HashMap<String, Carro>();

        // Adiciona elementos no map
        mapCarros.put("Renaut", new Carro("Sandero"));
        mapCarros.put("Renaut", new Carro("Fluence"));
        mapCarros.put("Ford", new Carro("Fiesta"));
        mapCarros.put("Chevrolet", new Carro("Celta"));
        mapCarros.put("Fiat", new Carro("Palio"));

        System.out.println("Exemplo de map: " + mapCarros);

        System.out.println("----------------------------------------");

        // Remove o elemento da posição informada
        System.out.println(mapCarros.remove("Renaut"));
        System.out.println("Remove o elemento da posição informada: " + mapCarros);

        System.out.println("----------------------------------------");

        // Retorna o elemento da posição informada
        System.out.println(mapCarros.get("Ford"));
        System.out.println("Retorna o elemento da posição informada: " + mapCarros);

        System.out.println("----------------------------------------");

        // Verifica se o map contém o elemento informado
        System.out.println("Retorna true se o map contém o elemento informado: " + mapCarros.containsKey("Fiat"));
        
        System.out.println("----------------------------------------");

        // Verifica se o map contém o elemento informado
        System.out.println("Retorna true se o map contém o elemento informado: " + mapCarros.containsValue(new Carro("Palio")));

        System.out.println("----------------------------------------");

        // Verifica se o map está vazio
        System.out.println("Retorna true se o map estiver vazio: " + mapCarros.isEmpty());

        // Retorna o tamanho do map
        System.out.println("Retorna o tamanho do map: " + mapCarros.size());

        System.out.println("----------------------------------------");

        // O método keySet() retorna um Set com todas as chaves do map
        System.out.println("Retorna um Set com todas as chaves do map: " + mapCarros.keySet());

        System.out.println("----------------------------------------");

        // O método values() retorna um Collection com todos os valores do map
        System.out.println("Retorna um Collection com todos os valores do map: " + mapCarros.values());

        System.out.println("----------------------------------------");
        

    }
}
