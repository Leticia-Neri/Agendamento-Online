package com.example.demo.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class Paciente {

    @Id
    private String codigo;
    private String nome;
    private String sobrenome;
    private String sexo;
    private Endereco endereco;
    private String cpf;
    //@JsonFormat(pattern = "dd/MM/yyyy")
    private String dataNasc;
    private String telefone;

    public Paciente(String nome, String sobrenome, String sexo, Endereco endereco, String cpf, String dataNasc,
                    String telefone) {
        super();
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.endereco = endereco;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.telefone = telefone;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getDataNasc() {
        return dataNasc;
    }
    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}