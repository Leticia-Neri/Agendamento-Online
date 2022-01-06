package com.example.demo.controller;

import com.example.demo.dto.PacienteDTO;
import com.example.demo.models.Paciente;
import com.example.demo.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Agendamento;
import com.example.demo.repository.PacienteRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
//pacientes
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @Autowired
    PacienteRepository pacienteRepository;

    @PostMapping("/salvarPaciente")
    @Operation(summary="Salva um paciente")
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente salvar(@RequestBody Paciente paciente){
        return pacienteService.salvar(paciente);
    }

    /*
    @PostMapping("/salvarPaciente")
    public PacienteDTO salvar(@RequestBody PacienteDTO pacienteDTO){
        return PacienteDTO.convert(pacienteService.salvar(Paciente.convert(pacienteDTO)));
    }
     */

    @DeleteMapping(path = "/{id}")
    @Operation(summary="Deletar um paciente")
    public ResponseEntity<Void> deletar(@PathVariable String id){
        pacienteService.deletar(id);
        return  ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    @Operation(summary="Atualizar um paciente")
    public ResponseEntity<Paciente> atualizar(@PathVariable String id, @RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.atualizar(paciente));
    }

    @GetMapping(path = "/{id}")
    @Operation(summary="Retornar um paciente pelo codigo")
    public ResponseEntity<Paciente> obterPorCodigo(@PathVariable String id){
        Paciente paciente = pacienteService.obterPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(paciente);
    }

    /*
    @GetMapping(path = "/{id}")
    @Operation(summary="Retornar um pacinete pelo codigo")
    public PacienteDTO obterPorCodigo(@PathVariable String id){
       Paciente paciente =  pacienteService.obterPorId(id);
       return PacienteDTO.convert(paciente);
    }
     */

    @GetMapping
    @Operation(summary="Retornar todos os pacientes")
    public ResponseEntity<List<Paciente>> obterTodos(){
        return ResponseEntity.ok().body(pacienteService.obterTodos());
    }

    /*
    @GetMapping
    @Operation(summary="Retornar todos os pacinetes")
    public List<PacienteDTO>obterTodos(){
        List<Paciente> paciente = pacienteService.obterTodos();
        return paciente.stream().map(p -> PacienteDTO.convert(p)).collect(Collectors.toList());
    }
    */
}