package com.github.t1redaf.Exception;

public class NotFoundArticleException extends RuntimeException{

    String message;

    public NotFoundArticleException(String message) {
        super(message);
        this.message = message;
    }
}
