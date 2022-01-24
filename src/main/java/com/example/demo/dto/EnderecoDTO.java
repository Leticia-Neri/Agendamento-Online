package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class EnderecoDTO {

    @NotEmpty(message = "O campo estado não pode ser nulo")
    private String estado;
    @NotEmpty(message = "O campo cidade não pode ser nulo")
    private String cidade;
    @NotEmpty(message = "O campo bairro não pode ser nulo")
    private String bairro;
    @NotEmpty(message = "O campo rua não pode ser nulo")
    private String rua;
    @NotEmpty(message = "O campo numero não pode ser nulo")
    private String numero;
    //@Pattern("(\\d{2})\\d{4}\\d{4}")
    private String cep;
    private String complemento;

    public EnderecoDTO() {
    }

    public EnderecoDTO(String estado, String cidade, String bairro, String rua, String numero, String cep, String complemento) {

        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.complemento = complemento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
