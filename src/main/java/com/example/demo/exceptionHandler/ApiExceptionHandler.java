
package com.example.demo.exceptionHandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;




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


    /*
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

        MensagemException mensagemException = new  MensagemException(status.getReasonPhrase(), HttpStatus.METHOD_NOT_ALLOWED);
        return super.handleExceptionInternal(ex, mensagemException, headers, status, request);
    }

     */



    /*

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleMethodArgumentNotValid(ex, headers, status, request);
    }

     */


