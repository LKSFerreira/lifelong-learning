public class SumTest {
    public static long calculateSum(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 1000000000; // Defina o tamanho do teste

        long startTime = System.currentTimeMillis();
        long totalSum = calculateSum(n);
        long endTime = System.currentTimeMillis();

        System.out.println("Soma: " + totalSum);
        System.out.println("Tempo de execução do Java: " + (endTime - startTime) / 1000.0 + " segundos");
    }
}
