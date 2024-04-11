import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import exceptions.ErroConsultaGitHubException;
import utils.JavaUtils;

public class ApiGithub {
    public static void main(String[] args) {

        System.out.println("\nDigite o nome de usuário do GitHub: ");

        Scanner scanner = new Scanner(System.in);
        String usuario = "lksferreira"; //scanner.nextLine();

        String endpoint = "https://api.github.com/users/" + usuario;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(HttpRequest.newBuilder().uri(URI.create(endpoint)).build(),
                    HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 404) {
                throw new ErroConsultaGitHubException("Usuário não encontrado.");
            }

            System.out.println("Usuário encontrado.\n");

            System.out.println(JavaUtils.formatJson(response.body() + "\n"));

            File file = new File("./src/data/" + usuario + ".json");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(response.body());
            fileWriter.close();

        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());

        } catch (ErroConsultaGitHubException ex) {
            System.out.println(ex.getMessage());
        } finally {
            scanner.close();
        }      

    }
}
