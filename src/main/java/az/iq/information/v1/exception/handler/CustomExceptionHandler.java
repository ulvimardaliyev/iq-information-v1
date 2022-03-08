package az.iq.information.v1.exception.handler;

import az.iq.information.v1.constant.ExceptionResponse;
import az.iq.information.v1.exception.EmailExistException;
import az.iq.information.v1.exception.Response;
import az.iq.information.v1.exception.UserExistException;
import az.iq.information.v1.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<Response> userNotFound() {
        Response response = Response
                .builder()
                .code(ExceptionResponse.USER_NOT_FOUND.getStatusCode())
                .message(ExceptionResponse.USER_NOT_FOUND.getMessage())
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({UserExistException.class})
    public ResponseEntity<Response> userExist() {
        Response response = Response
                .builder()
                .code(ExceptionResponse.USER_ALREADY_EXIST.getStatusCode())
                .message(ExceptionResponse.USER_ALREADY_EXIST.getMessage())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({EmailExistException.class})
    public ResponseEntity<Response> emailExist() {
        Response response = Response
                .builder()
                .code(ExceptionResponse.EMAIL_ALREADY_REGISTERED.getStatusCode())
                .message(ExceptionResponse.EMAIL_ALREADY_REGISTERED.getMessage())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
