package com.example.demo.controller;

import com.example.demo.dto.PacienteDTO;

import com.example.demo.models.Paciente;
import com.example.demo.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Agendamento;
import com.example.demo.repository.PacienteRepository;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;



@RestController
//pacientes
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @Autowired
    PacienteRepository pacienteRepository;

    private static final Logger log = LoggerFactory.getLogger(PacienteController.class);

    @PostMapping("/salvarPaciente")
    @Operation(summary="Salva um paciente")
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente salvar(@RequestBody @Valid PacienteDTO pacienteDTO){

        log.info("Entrando no metódo salvar paciente pelo codigo {}", pacienteDTO.getCpf());

        Paciente paciente = pacienteService.convertPacienteDto(pacienteDTO);

        log.info("Agendamento salvo com sucesso retornando no corpo da requisicao o Agendamento e Status CREATED");
        return pacienteService.salvar(paciente);
    }


    @DeleteMapping(path = "/{id}")
    @Operation(summary="Deletar um paciente")
    public ResponseEntity<Object> deletar(@PathVariable String id){

        log.info("Entrando no metódo deletar paciente pelo codigo");

        if(!pacienteRepository.existsById(id)){
            log.info("Paciente não encontrado");
            return new ResponseEntity<>("Paciente não encontrado",HttpStatus.NOT_FOUND);
        }

        pacienteService.deletar(id);

        log.info("Deletando agendamento e retornando status noContent");
        return  ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    @Operation(summary="Atualizar um paciente")
    public ResponseEntity<Paciente> atualizar(@PathVariable String id, @RequestBody PacienteDTO pacienteDTO){

        log.info("Entrando no metódo salvar paciente pelo codigo");

        Paciente paciente = pacienteService.convertPacienteDto(pacienteDTO);

        paciente.setCodigo(id);
        paciente = pacienteService.atualizar(paciente);

        log.info("Agendamendo atualizando e status ok");
        return ResponseEntity.ok(paciente);
    }

    @GetMapping(path = "/{id}")
    @Operation(summary="Retornar um paciente pelo codigo")
    public ResponseEntity<Paciente> obterPorCodigo(@PathVariable String id){

        log.info("Entrando no metódo retornar paciente pelo codigo \r\n Buscando paciente por id no banco de dados");
        if (!pacienteRepository.existsById(id)) {
            log.info("Paciente com id:{} não existe e retorno not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Paciente paciente = pacienteService.obterPorId(id);

        log.info("Retornando paciente no corpo da requisição e status ok");
        return ResponseEntity.status(HttpStatus.OK).body(paciente);
    }


    @GetMapping
    @Operation(summary="Retornar todos os pacientes")
    public ResponseEntity<List<Paciente>> obterTodos(){

        log.info("Entrando no metódo retornar todos pacientes");

        List<Paciente> lista = pacienteService.obterTodos();

        if(lista.isEmpty()){
            log.info("Lista vazia retorno not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.info("Retornando pacientes e status ok");
        return ResponseEntity.ok().body(pacienteService.obterTodos());
    }

    @GetMapping(path ="/nome/{nome}")
    public ResponseEntity<Paciente> obterNome(@PathVariable String nome){

        Paciente paciente = pacienteService.obterPorNome(nome);

        return ResponseEntity.ok().body(paciente);



    }

}