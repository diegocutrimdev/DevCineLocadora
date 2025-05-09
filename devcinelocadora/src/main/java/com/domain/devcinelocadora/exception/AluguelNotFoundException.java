package com.domain.devcinelocadora.exception;

public class AluguelNotFoundException extends RuntimeException{
    public AluguelNotFoundException(String message) {
        super(message);
    }
}
