package com.example.demo.controller;

import com.example.demo.dto.PacienteDTO;
import com.example.demo.exceptionHandler.ApiRequestException;
import com.example.demo.models.Endereco;
import com.example.demo.models.Paciente;
import com.example.demo.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Agendamento;
import com.example.demo.repository.PacienteRepository;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
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

    Logger log = Logger.getLogger("com.example.demo.controller");

    @PostMapping("/salvarPaciente")
    @Operation(summary="Salva um paciente")
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente salvar(@RequestBody @Valid PacienteDTO pacienteDTO){

        Paciente paciente = pacienteService.convertPacienteDto(pacienteDTO);



        /*
        if(paciente.getNome().isEmpty()){
            throw new
        }

         */

        log.info("Agendamento salvo com sucesso retornando no corpo da requisicao o Agendamento e Status CREATED");
        return pacienteService.salvar(paciente);
    }


    @DeleteMapping(path = "/{id}")
    @Operation(summary="Deletar um paciente")
    public ResponseEntity<Void> deletar(@PathVariable String id){

        if(!pacienteRepository.existsById(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        pacienteService.deletar(id);

        log.info("Deletando agendamento e retornando status noContent");
        return  ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    @Operation(summary="Atualizar um paciente")
    public ResponseEntity<Paciente> atualizar(@PathVariable String id, @RequestBody PacienteDTO pacienteDTO){

        Paciente paciente = pacienteService.convertPacienteDto(pacienteDTO);
        boolean pacienteExiste = this.pacienteRepository.existsById(paciente.getCodigo());

        if(!pacienteExiste){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        paciente.setCodigo(id);
        paciente = pacienteService.atualizar(paciente);

        log.info("Agendamendo atualizando e status ok");
        return ResponseEntity.ok(pacienteService.atualizar(paciente));
    }

    @GetMapping(path = "/{id}")
    @Operation(summary="Retornar um paciente pelo codigo")
    public ResponseEntity<Paciente> obterPorCodigo(@PathVariable String id){

        if (!pacienteRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Paciente paciente = pacienteService.obterPorId(id);

        log.info("Retornando agendamento no corpo da requisição e status ok");
        return ResponseEntity.status(HttpStatus.OK).body(paciente);
    }


    @GetMapping
    @Operation(summary="Retornar todos os pacientes")
    public ResponseEntity<List<Paciente>> obterTodos(){

        List<Paciente> lista = pacienteService.obterTodos();

        if(lista.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.info("Retornando usuários e status ok");
        return ResponseEntity.ok().body(pacienteService.obterTodos());
    }

}