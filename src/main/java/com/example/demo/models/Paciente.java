package com.example.demo.models;
import com.example.demo.dto.PacienteDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Document
public class Paciente {

    @Id
    private String codigo;
    @Schema(description = "Nome do paciente", example = "Laura")
    @NotEmpty(message = "O campo nome não pode ser nulo")
    private String nome;
    @Schema(description = "Sobrenome do paciente", example = "Ramos")
    @NotEmpty(message = "O campo sobrenome não pode ser nulo")
    private String sobrenome;
    @Schema(description = "Sexo do paciente", example = "Feminino")
    @NotEmpty(message = "O campo sexo não pode ser nulo")
    private String sexo;
    @Schema(description = "Endereço do paciente")
    private Endereco endereco;
    @Schema(description = "Cpf do paciente", example = "12345678998")
    @CPF(message = "cpf inválido")
    private String cpf;
    //@JsonFormat(pattern = "dd/MM/yyyy")
    @Schema(description = "Data de nascimento do paciente", example = "03/09/1980")
    private String dataNasc;
    @Schema(description = "Tefone do paciente", example = "12345678")
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

    public Paciente() {
    }

    public Paciente(PacienteDTO pacienteDTO){
        this.nome = pacienteDTO.getNome();
        this.sobrenome = pacienteDTO.getSobrenome();
        this.sexo = pacienteDTO.getSexo();
        this.endereco = pacienteDTO.getEndereco();
        this.cpf = pacienteDTO.getCpf();
        this.dataNasc = pacienteDTO.getDataNasc();
        this.telefone = pacienteDTO.getTelefone();
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