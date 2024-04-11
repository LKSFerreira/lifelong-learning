package exceptions;

public class ErroConsultaGitHubException extends RuntimeException {
    public ErroConsultaGitHubException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Erro ao consultar o GitHub. " + super.getMessage();
    }
}
