import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import mapping.PessoaMapping;
import models.Pessoa;

public class App {
    public static void main(String[] args) throws Exception {

        String json = """
                {
                    "Nome": "Lucas Ferreira",
                    "Idade": 32,
                    "Email": "lks_ferreira@hotmail.com",
                    "Cidade": "São José do Rio Preto",
                    "UF": "SP"
                }
                        """;

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
        System.out.println("\n--- GSON ---");
        System.out.println(gson.toJson(json));

        PessoaMapping pessoaMapping = gson.fromJson(json, PessoaMapping.class);
        System.out.println("\n--- PessoaMapping ---");
        System.out.println(pessoaMapping);

        Pessoa pessoa = new Pessoa(pessoaMapping);
        System.out.println("\n--- Pessoa ---");
        System.out.println(pessoa);

        System.out.println("=====================================");

        String jsonLivro = "{\"titulo\":\"Aventuras do Java\",\"autor\":\"Akemi\",\"editora\":{\"nome\":\"TechBooks\",\"cidade\":\"São Paulo\"}}";
        jsonLivro = """
                {
                    "titulo": "Aventuras do Java",
                    "autor": "Akemi",
                    "editora": {
                        "nome": "TechBooks",
                        "cidade": "São Paulo"
                    }
                }
                """; // Formato JSON com quebra de linha

        Gson newGson = new Gson();
        Livro livro = newGson.fromJson(jsonLivro, Livro.class);

        System.out.println("Objeto Livro: " + livro);

    }

    // O forma de criar um record é bem parecido com a criação de uma classe
    // A diferença é que não é necessário criar os métodos getters, setters, equals, hashcode e toString
    // Além disso, chamaos esse tipo de Inner Class de Record, pois é classe interna
    record Editora(String nome, String cidade) {
    }

    record Livro(String titulo, String autor, Editora editora) {
    }
}
