package com.example.demo.dto;

import com.example.demo.models.Paciente;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotEmpty;

public class AgendamentoDTO {


    @NotEmpty
    private String especialidade;
    private String data;
    private String unidade;
    private Paciente paciente;

    public AgendamentoDTO() {
    }

    public AgendamentoDTO( String especialidade, String data, String unidade, Paciente paciente) {

        this.especialidade = especialidade;
        this.data = data;
        this.unidade = unidade;
        this.paciente = paciente;
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
