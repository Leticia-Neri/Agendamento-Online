package com.example.demo.controller;

import com.example.demo.models.Paciente;
import com.example.demo.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Agendamento;
import com.example.demo.repository.PacienteRepository;

import java.util.List;

@RestController
//pacientes
@RequestMapping("/api")
public class PacienteController {

    /*
    @Autowired
    PacienteRepository pacienteRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/salvarPaciente")
    public Paciente novoPaciente(@RequestBody Paciente paciente) {
        pacienteRepository.save(paciente);
        return paciente;
    }
     */

    @Autowired
    PacienteService pacienteService;

    @PostMapping("/salvarPaciente")
    public Paciente salvar(@RequestBody Paciente paciente){
        pacienteService.salvar(paciente);
        return paciente;
    }

    @DeleteMapping(path = "/{id}")
    public void deletar(@PathVariable String id){
        pacienteService.deletar(id);
    }

    @PutMapping(path = "/{id}")
    public Paciente atualizar(@PathVariable String id, @RequestBody Paciente paciente){
        return pacienteService.atualizar(paciente);
    }

    @GetMapping(path = "/{id}")
    public Paciente obterPorCodigo(@PathVariable String id){
        return pacienteService.obterPorId(id);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> obterTodos(){
        return ResponseEntity.ok().body(pacienteService.obterTodos());
    }
}