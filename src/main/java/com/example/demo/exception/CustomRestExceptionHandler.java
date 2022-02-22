package com.example.demo.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {



    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ApiError.Campo> campos = new ArrayList<>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String nome = ((FieldError) error).getField();
            String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            campos.add(new ApiError.Campo(nome, mensagem));
        }

        ApiError apiError = new ApiError();
        apiError.setStatus(status.value());
        apiError.setDataHora(OffsetDateTime.now());
        apiError.setTitulo("Um ou mais campos inválidos. Preencha corretamente!");
        apiError.setCampos(campos);

        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleNegocio(RuntimeException ex, WebRequest request){

        HttpStatus status = HttpStatus.BAD_REQUEST;

        ApiError apiError = new ApiError();
        apiError.setStatus(status.value());
        apiError.setDataHora(OffsetDateTime.now());
        apiError.setTitulo(ex.getMessage());

        return handleExceptionInternal(ex, apiError, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> accessDenied(SecurityException ex, WebRequest request){
        HttpStatus status = HttpStatus.FORBIDDEN;

        ApiError securityMessage = new ApiError();
        securityMessage.setStatus(status.value());
        securityMessage.setDataHora(OffsetDateTime.now());
        securityMessage.setTitulo("Acesso negado");
        return handleExceptionInternal(ex, securityMessage, new HttpHeaders(), status, request);
    }



}

