// JavaMeanCalculation.java
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JavaMeanCalculation {
    public static void main(String[] args) {
        // Definir o tamanho do conjunto de dados e o limiar
        int size = 100000000; // 100 milhões de pontos de dados
        double threshold = 0.5;

        // Gerar um grande conjunto de dados
        List<Double> data = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            data.add(random.nextDouble());
        }

        long startTime = System.currentTimeMillis();

        // Filtrar os dados e calcular a média dos valores filtrados
        double meanValue = data.stream()
                .filter(value -> value > threshold)
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(Double.NaN);

        long endTime = System.currentTimeMillis();

        System.out.println("Média dos valores acima do limiar: " + meanValue);
        System.out.println("Tempo de execução do Java: " + (endTime - startTime) / 1000.0 + " segundos");
    }
}