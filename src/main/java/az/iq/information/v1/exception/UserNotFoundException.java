package az.iq.information.v1.exception;

public class UserNotFoundException extends RuntimeException {
    private String message;

    public UserNotFoundException(String message) {
        super(message);
    }
}
