package com.example.demo.exceptionHandler;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

public class MensagemException {

    private Integer status;
    private String error;
    private String message;
    private String path;

    public MensagemException() {
    }

    public MensagemException( Integer status, String error, String message, String path) {

        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}


