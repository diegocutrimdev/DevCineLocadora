package com.domain.devcinelocadora.exception;

public class FilmeNotFoundException extends RuntimeException{
    public FilmeNotFoundException(String message) {
        super(message);
    }
}
