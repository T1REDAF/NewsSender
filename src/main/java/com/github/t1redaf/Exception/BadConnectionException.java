package com.github.t1redaf.Exception;

public class BadConnectionException extends RuntimeException {

    String message;
    public BadConnectionException(String message) {
        super(message);
        this.message = message;
    }
}
