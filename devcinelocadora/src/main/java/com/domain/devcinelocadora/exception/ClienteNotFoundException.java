package com.domain.devcinelocadora.exception;

public class ClienteNotFoundException extends RuntimeException{
    public ClienteNotFoundException(String message) {
        super(message);
    }
}
