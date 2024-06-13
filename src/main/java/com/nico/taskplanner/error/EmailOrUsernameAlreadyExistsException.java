package com.nico.taskplanner.error;

public class EmailOrUsernameAlreadyExistsException extends Exception {

    public EmailOrUsernameAlreadyExistsException() {
        super();
    }

    public EmailOrUsernameAlreadyExistsException(String message) {
        super(message);
    }

    public EmailOrUsernameAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailOrUsernameAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    protected EmailOrUsernameAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
