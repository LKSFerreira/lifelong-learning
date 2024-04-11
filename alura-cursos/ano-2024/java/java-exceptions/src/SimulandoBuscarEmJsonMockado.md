```java
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String busca = "Matrix";

        try {
            String content = new String(Files.readAllBytes(Paths.get("caminho/para/seu/arquivo/filmes.json")));
            JSONObject filmes = new JSONObject(content);

            if (filmes.has(busca)) {
                JSONObject filme = filmes.getJSONObject(busca);
                System.out.println(filme.toString());
            } else {
                System.out.println("Filme não encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

Neste exemplo, substitua `"caminho/para/seu/arquivo/filmes.json"` pelo caminho real para o seu arquivo JSON. Este código lê o arquivo JSON, converte-o em um `JSONObject`, e então verifica se o filme que você está buscando existe no objeto. Se existir, ele imprime os detalhes do filme.

Note que você precisa adicionar a biblioteca `org.json` ao seu projeto. Você pode fazer isso adicionando a seguinte dependência ao seu arquivo `pom.xml` se estiver usando Maven:

```xml
<dependency>
    <groupId>org.json</groupId>
    <artifactId>json</artifactId>
    <version>20210307</version>
</dependency>
```