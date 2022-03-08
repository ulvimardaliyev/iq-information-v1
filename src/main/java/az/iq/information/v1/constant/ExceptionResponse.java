package az.iq.information.v1.constant;

import lombok.Getter;

@Getter
public enum ExceptionResponse {
    USER_NOT_FOUND(1004, "User Not Found"),
    USER_ALREADY_EXIST(1009, "User already exist"),
    EMAIL_ALREADY_REGISTERED(1010, "Email already registered");

    private int statusCode;
    private String message;

    ExceptionResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

}
