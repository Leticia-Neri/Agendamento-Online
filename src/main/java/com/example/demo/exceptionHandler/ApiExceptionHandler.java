
package com.example.demo.exceptionHandler;


import com.example.demo.exception.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;


//conseguir fazer o mapeamento do tratamento de exceções
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {

        MensagemException mensagemException = new MensagemException(e.getMessage(), HttpStatus.BAD_REQUEST);

        //return response entity
        return new ResponseEntity<>(mensagemException, HttpStatus.BAD_REQUEST);
    }






}






