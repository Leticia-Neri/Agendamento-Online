package com.example.demo.exceptionHandler;

public class ApiRequestException extends RuntimeException{

    //private static final String message ="cpf já cadastrado";
    public ApiRequestException(String message) {
        super(message);
    }

}
