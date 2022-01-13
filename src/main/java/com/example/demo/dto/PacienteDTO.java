package com.example.demo.dto;

import com.example.demo.models.Endereco;
import com.example.demo.models.Paciente;

import javax.validation.constraints.NotEmpty;

public class PacienteDTO {

    private String codigo;
    @NotEmpty
    private String nome;
    private String sobrenome;
    private String sexo;
    private Endereco endereco;
    private String cpf;
    private String dataNasc;
    private String telefone;

    public PacienteDTO() {
    }

    public PacienteDTO(String codigo,String nome, String sobrenome, String sexo, Endereco endereco, String cpf, String dataNasc, String telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.endereco = endereco;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.telefone = telefone;
    }

    public PacienteDTO(Paciente paciente){
        this.codigo = paciente.getCodigo();
        this.nome = paciente.getNome();
        this.sobrenome = paciente.getSobrenome();
        this.sexo = paciente.getSexo();
        this.endereco = paciente.getEndereco();
        this.cpf = paciente.getCpf();
        this.dataNasc = paciente.getDataNasc();
        this.telefone = paciente.getTelefone();
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
