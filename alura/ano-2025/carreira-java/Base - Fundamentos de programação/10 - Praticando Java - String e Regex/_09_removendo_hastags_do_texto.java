import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _09_removendo_hastags_do_texto {
        public static void main(String[] args) {
        // Variável com o texto
        String texto = "Olá #mundo! Estou aprendendo #Java e #programação.";
        
        // Cria o padrão regex para encontrar hashtags
        // # = símbolo hashtag literal
        // [a-zA-ZÀ-ÿ0-9_]+ = uma ou mais letras, números ou underscore
        Pattern pattern = Pattern.compile("#[a-zA-ZÀ-ÿ0-9_]+");
        
        // Cria o matcher para buscar no texto
        Matcher matcher = pattern.matcher(texto);
        
        // Lista para armazenar as hashtags encontradas
        StringBuilder hashtags = new StringBuilder();
        
        // Busca todas as ocorrências
        while (matcher.find()) {
            if (hashtags.length() > 0) {
                hashtags.append(", ");
            }
            hashtags.append(matcher.group());
        }
        
        // Exibe o resultado
        if (hashtags.length() > 0) {
            System.out.println("Hashtags encontradas: " + hashtags);
        } else {
            System.out.println("Nenhuma hashtag encontrada.");
        }
    }
}
