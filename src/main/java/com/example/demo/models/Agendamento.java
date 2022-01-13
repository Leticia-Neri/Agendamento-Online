package com.example.demo.models;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document
public class Agendamento {

    @Id
    @Schema(description = "Id do usuario")
    private String codigo;
    @Schema(description = "Especialidade da consulta", example = "Dermatologista")
    private String especialidade;
    //@JsonFormat(pattern="dd/MM/yyyy")
    @Schema(description = "Data da consulta", example = "05/10/2023")
    private String data;
    @Schema(description = "Unidade da consulta", example = "Vila Mariana")
    private String unidade;
    private Paciente paciente;

    public Agendamento() {
    }

    public Agendamento(String especialidade, String data, String unidade, Paciente paciente) {
        super();
        this.especialidade = especialidade;
        this.data = data;
        this.unidade = unidade;
        this.paciente = paciente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}