
package com.example.demo.exceptionHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

//conseguir fazer o mapeamento do tratamento de exceções
@ControllerAdvice
public class ApiExceptionHandler  {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){

        MensagemException mensagemException = new MensagemException(e.getMessage(), HttpStatus.NOT_FOUND);

        //return response entity
        return new ResponseEntity<>(mensagemException, HttpStatus.BAD_REQUEST);
    }


}
