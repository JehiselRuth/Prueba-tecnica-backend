package com.pruebatec.pruebatecbackend.exception;

public class UserServiceException extends RuntimeException{
    public UserServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
