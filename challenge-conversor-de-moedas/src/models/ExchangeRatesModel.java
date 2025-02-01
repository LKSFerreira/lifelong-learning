package models;

import java.util.LinkedHashMap;
import java.util.Map;

import log.LogConversion;

public class ExchangeRatesModel {
        private double pesoArgentino;
        private double bolivianoBoliviano;
        private double realBrasileiro;
        private double pesoChileno;
        private double pesoColombiano;
        private double dolarAmericano;

        private String baseCurrency;
        private String targetCurrency;

        private static final LogConversion logService = new LogConversion();

        public ExchangeRatesModel(ExchangeRatesRecord exchangeRatesRecord) {
                this.pesoArgentino = exchangeRatesRecord.ars();
                this.bolivianoBoliviano = exchangeRatesRecord.bob();
                this.realBrasileiro = exchangeRatesRecord.brl();
                this.pesoChileno = exchangeRatesRecord.clp();
                this.pesoColombiano = exchangeRatesRecord.cop();
                this.dolarAmericano = exchangeRatesRecord.usd();
        }

        public ExchangeRatesModel(String baseCurrency, String targetCurrency) {
                this.baseCurrency = baseCurrency;
                this.targetCurrency = targetCurrency;
        }

        public void getExchangeRateOneToOne(Double valueToConvert, Double exchangeRate) {
                validarValor(valueToConvert);
                validarTaxaDeCambio(exchangeRate);

                double valorConvertido = calcularConversao(valueToConvert, exchangeRate);
                String formattedMessage = String.format("Total de %.2f %s em %s ----> %.2f",
                                valueToConvert,
                                baseCurrency.toUpperCase(),
                                targetCurrency.toUpperCase(),
                                valorConvertido);

                System.out.print("\n" + formattedMessage + "\n\n");
                logService.logConversion(formattedMessage);
        }

        public void getExchangeRates(double valueToConvert) {
                validarValor(valueToConvert);

                Map<String, Double> moedas = new LinkedHashMap<>(); // LinkedHashMap mantém a ordem
                moedas.put("Real brasileiro", realBrasileiro);
                moedas.put("Dólar americano", dolarAmericano);
                moedas.put("Peso argentino", pesoArgentino);
                moedas.put("Boliviano boliviano", bolivianoBoliviano);
                moedas.put("Peso chileno", pesoChileno);
                moedas.put("Peso colombiano", pesoColombiano);

                int maiorNomeMoeda = moedas.keySet().stream().mapToInt(String::length).max().orElse(0);
                System.out.println();

                for (Map.Entry<String, Double> entry : moedas.entrySet()) {
                        String nomeMoeda = entry.getKey();
                        double taxaCambio = entry.getValue();
                        validarTaxaDeCambio(taxaCambio);
                        double valorConvertido = calcularConversao(valueToConvert, taxaCambio);

                        // Calcula o número de traços a serem preenchidos
                        int numTracos = maiorNomeMoeda - nomeMoeda.length();
                        String tracos = "-".repeat(numTracos + 1);

                        // Formata e imprime a linha
                        String formattedString = String.format("%s %s> %,.2f", nomeMoeda, tracos, valorConvertido);
                        System.out.printf("%s\n", formattedString);
                        logService.logConversion(formattedString);
                }

                System.out.println();
        }

        private void validarValor(double value) {
                if (value <= 0) {
                        throw new IllegalArgumentException("O valor não pode ser menor ou igual a zero.");
                }
                if (Double.isInfinite(value) || Double.isNaN(value)) {
                        throw new IllegalArgumentException("O valor não pode ser infinito ou NaN.");
                }
        }

        private void validarTaxaDeCambio(double taxa) {
                if (taxa <= 0) {
                        throw new IllegalArgumentException(
                                        "As taxas de câmbio não podem ser menores ou iguais a zero.");
                }
        }

        private double calcularConversao(double valor, double taxaDeCambio) {
                return valor * taxaDeCambio;
        }

        @Override
        public String toString() {
                return String.format("Real brasileiro:       %,.2f%n" +
                                "Peso argentino:        %,.2f%n" +
                                "Boliviano boliviano:   %,.2f%n" +
                                "Peso chileno:          %,.2f%n" +
                                "Peso colombiano:       %,.2f%n" +
                                "Dólar americano:       %,.2f%n",
                                realBrasileiro, pesoArgentino, bolivianoBoliviano, pesoChileno, pesoColombiano,
                                dolarAmericano);
        }

}
