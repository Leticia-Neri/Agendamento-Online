package com.example.demo.service;

import com.example.demo.dto.PacienteDTO;
import com.example.demo.models.Paciente;

import java.util.List;

public interface PacienteService {

    Paciente salvar(Paciente paciente);

    void deletar(String id);

    Paciente atualizar(Paciente paciente);

    Paciente obterPorId(String id);

    List<Paciente> obterTodos();

    PacienteDTO convertePaciente(Paciente paciente);

    Paciente obterPorNome(String nome);

    Paciente convertPacienteDto(PacienteDTO pacienteDTO);

}
