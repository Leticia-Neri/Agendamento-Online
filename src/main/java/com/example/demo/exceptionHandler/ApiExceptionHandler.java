
package com.example.demo.exceptionHandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;



@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;
        MensagemException mensagemException = new MensagemException(status.value(), "Já cadastrado", e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(mensagemException);
    }





//    @ExceptionHandler({AccessDeniedException.class})
//    public ResponseEntity accessDenied(AccessDeniedException e, HttpServletRequest request ){
//        HttpStatus status = HttpStatus.FORBIDDEN;
//        MensagemException mensagemException = new MensagemException(status.value(), "Negado", e.getMessage(), request.getRequestURI());
//        return ResponseEntity.status(status).body(mensagemException);
//    }

}






