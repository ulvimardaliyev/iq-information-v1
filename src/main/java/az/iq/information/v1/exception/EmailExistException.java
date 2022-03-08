package az.iq.information.v1.exception;

public class EmailExistException extends RuntimeException {
    private String message;

    public EmailExistException(String message) {
        super(message);
    }
}
