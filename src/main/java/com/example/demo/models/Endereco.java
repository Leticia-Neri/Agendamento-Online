package com.example.demo.models;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Endereco {

    @Id
    @Schema(description = "Id do endereço")
    private String codigo;
    @Schema(description = "Estado do endereço", example = "São Paulo")
    private String estado;
    @Schema(description = "Cidade do endereço", example = "São Paulo")
    private String cidade;
    @Schema(description = "Bairro do endereço", example = "Mooca")
    private String bairro;
    @Schema(description = "Rua do endereço", example = "Rua Jardim")
    private String rua;
    @Schema(description = "Número do endereço", example = "123")
    private String numero;
    @Schema(description = "Cep do endereço", example = "12345678")
    private String cep;
    private String complemento;

    public Endereco(String estado, String cidade, String bairro, String rua, String numero, String cep,
                    String complemento) {
        super();
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.complemento = complemento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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