package exceptions;

public class SenhaInvalidaException extends RuntimeException {
    public SenhaInvalidaException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Senha inválida. " + super.getMessage();
    }
}
