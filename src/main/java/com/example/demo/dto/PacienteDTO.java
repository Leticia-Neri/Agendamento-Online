package com.example.demo.dto;

import com.example.demo.models.Endereco;
import com.example.demo.models.Paciente;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.nio.charset.StandardCharsets;

public class PacienteDTO {

    @NotEmpty(message = "O campo nome não pode ser nulo")
    @Pattern(regexp = "^[A-Za-z ]+$")
    private String nome;
    @NotEmpty(message = "O campo sobrenome não pode ser nulo")
    private String sobrenome;
    @NotEmpty(message = "O campo sexo não pode ser nulo")
    private String sexo;
    private Endereco endereco;
   // @CPF(message = "cpf iválido")
    private String cpf;
    @Pattern(regexp = "^[0-9/]+$", message = "Data de nascimento deve conter apenas números")
    private String dataNasc;
    private String telefone;

    public PacienteDTO() {
    }

    public PacienteDTO(String nome, String sobrenome, String sexo, Endereco endereco, String cpf, String dataNasc, String telefone) {

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.endereco = endereco;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.telefone = telefone;

    }

    public PacienteDTO(Paciente paciente){

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

}
