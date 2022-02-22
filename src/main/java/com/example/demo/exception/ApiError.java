package com.example.demo.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {

//    private HttpStatus status;
//    private Integer code;
//    private String message;
//    private List<String> errors;
//
//    public ApiError(String message) {
//        this.message = message;
//    }
//
//    public ApiError(HttpStatus status, Integer code, String message, List<String> erros){
//        super();
//        this.status = status;
//        this.code = code;
//        this.message = message;
//        this.errors = erros;
//
//    }
//
//    public ApiError(HttpStatus status, Integer code, String message, String error){
//        super();
//        this.status = status;
//        this.code = code;
//        this.message =message;
//        errors  = Arrays.asList(error);
//
//    }
//    public ApiError(HttpStatus status, String message, String error){
//        super();
//        this.status = status;
//        this.message =message;
//        errors  = Arrays.asList(error);
//
//    }
//    public ApiError() {
//    }
//
//
//
//    public HttpStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(HttpStatus status) {
//        this.status = status;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public List<String> getErrors() {
//        return errors;
//    }
//
//    public void setErrors(List<String> errors) {
//        this.errors = errors;
//    }
//
//    public Integer getCode() {
//        return code;
//    }
//
//    public void setCode(Integer code) {
//        this.code = code;
//    }



    private Integer status;
    private OffsetDateTime dataHora;
    private String titulo;
    private List<Campo> campos;

    public ApiError(Integer status, OffsetDateTime dataHora, String titulo, List<Campo> campos) {
        this.status = status;
        this.dataHora = dataHora;
        this.titulo = titulo;
        this.campos = campos;
    }

    public ApiError() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Campo> getCampos() {
        return campos;
    }

    public void setCampos(List<Campo> campos) {
        this.campos = campos;
    }

    public static class Campo{

        private String nome;
        private String mensagem;

        public Campo(String nome, String mensagem) {
            this.nome = nome;
            this.mensagem = mensagem;
        }

        public Campo() {
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getMensagem() {
            return mensagem;
        }

        public void setMensagem(String mensagem) {
            this.mensagem = mensagem;
        }
    }


}
