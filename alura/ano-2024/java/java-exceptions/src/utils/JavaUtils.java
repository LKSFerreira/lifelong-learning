package utils;

public class JavaUtils {
    public static String formatJson(String json) {
        StringBuilder formattedJson = new StringBuilder();
        int indent = 0;
        boolean inQuote = false;

        for (char c : json.toCharArray()) {
            switch (c) {
                case '\"':
                    // Se o caractere anterior não for uma barra invertida, então é um início/término de string
                    if (formattedJson.length() > 0 && formattedJson.charAt(formattedJson.length() - 1) != '\\') {
                        inQuote = !inQuote;
                    }
                    formattedJson.append(c);
                    break;
                case '{':
                case '[':
                    if (!inQuote) {
                        formattedJson.append(c).append("\n").append(" ".repeat(indent + 2));
                        indent += 2;
                    } else {
                        formattedJson.append(c);
                    }
                    break;
                case '}':
                case ']':
                    if (!inQuote) {
                        indent -= 2;
                        formattedJson.append("\n").append(" ".repeat(indent)).append(c);
                    } else {
                        formattedJson.append(c);
                    }
                    break;
                case ',':
                    if (!inQuote) {
                        formattedJson.append(c).append("\n").append(" ".repeat(indent));
                    } else {
                        formattedJson.append(c);
                    }
                    break;
                case ':':
                    if (!inQuote) {
                        formattedJson.append(c).append(" ");
                    } else {
                        formattedJson.append(c);
                    }
                    break;
                default:
                    formattedJson.append(c);
            }
        }

        return formattedJson.toString();
    }

}
