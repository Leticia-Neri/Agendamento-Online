package com.example.demo.controller;

import com.example.demo.models.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Agendamento;
import com.example.demo.repository.PacienteRepository;

@RestController
@RequestMapping("/api")
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/salvarPaciente")
    public Paciente novoPaciente(@RequestBody Paciente paciente) {
        pacienteRepository.save(paciente);
        return paciente;
    }
}