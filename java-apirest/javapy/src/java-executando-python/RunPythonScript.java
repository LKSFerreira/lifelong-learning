import java.io.*;

public class RunPythonScript {
    public static void main(String[] args) {
        // Caminho para o interpretador Python e o script Python
        String pythonPath = "python"; // ou "python3", dependendo da sua configuração
        String scriptPath = "src/operations.py";
        String valor1 = "1";
        String valor2 = "2";

        // Cria um ProcessBuilder
        ProcessBuilder processBuilder = new ProcessBuilder(pythonPath, scriptPath, valor1, valor2);

        try {
            // Inicia o processo
            Process process = processBuilder.start();

            // Lê a saída do script (stdout)
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            String[] operations = {"soma", "subtração", "multiplicação", "divisão"};
            int i = 0;
            while ((line = reader.readLine()) != null) {
                System.out.println("Resultado da " + operations[i++] + ": " + line);
            }

            // Aguarda a conclusão do processo
            int exitCode = process.waitFor();
            System.out.println("Script Python executado com código de saída: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}