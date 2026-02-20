package app.cryptostatus.principal;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import app.cryptostatus.model.DadosCrypto;
import app.cryptostatus.service.ConsumoApi;
import app.cryptostatus.service.ConverteDados;

public class CryptoStatusApp {
    public void run() {
        ConsumoApi consomeApi = new ConsumoApi();
        String endereco = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=50&page=1";

        String responseJson = null;

        try {
            responseJson = consomeApi.obterDados(endereco);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        ConverteDados convertDados = new ConverteDados();
        var dadosCrypto = convertDados.converteJsonParaObjeto(responseJson, DadosCrypto[].class);
        List<DadosCrypto> listaCrypto = Arrays.asList(dadosCrypto);

        System.out.println("\n");
        System.out.println("====================================");
        System.out.println("Cryptos disponiveis para consulta");
        System.out.println("====================================\n");
        listaCrypto.stream().forEach(item -> System.out.print("[" + item.id() + "] "));
        System.out.println("\n");

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("====================================");
            System.out.print("Digite o nome da moeda: ");
            String moeda = scanner.next();
            System.out.println("====================================");
            System.out.println("Informações da moeda");
            System.out.println("====================================");
            listaCrypto.stream().filter(item -> item.id().equals(moeda)).forEach(
                item -> System.out.println(
                    "ID: " + item.id() + "\n" +
                    "Nome: " + item.nome() + "\n" +
                    "Simbolo: " + item.simbolo() + "\n" +
                    "Preço: " + item.preco()));
        }
        System.out.println("============================");
        System.out.println("\n");
    }
}
