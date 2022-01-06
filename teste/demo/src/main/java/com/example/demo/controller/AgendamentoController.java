package com.example.demo.controller;

import com.example.demo.models.Agendamento;
import com.example.demo.models.Paciente;
import com.example.demo.service.AgendamentoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@CrossOrigin(origins = "*")
public class AgendamentoController {

    @Autowired
    AgendamentoService agendamentoService;

    @PostMapping("/salvarAgendamento")
    @Operation(summary="Salva um agendamento")
    @ResponseStatus(HttpStatus.CREATED)
    public Agendamento salvar(@RequestBody Agendamento agendamento){
        agendamentoService.salvar(agendamento);
        return agendamento;
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary="Deleta um agendamento")
    public ResponseEntity<Void> deletar(@PathVariable String id){
        agendamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    @Operation(summary="Atualiza um agendamento")
    public ResponseEntity<Agendamento> atualizar(@PathVariable String id, @RequestBody Agendamento agendamento){
        return ResponseEntity.ok().body(agendamentoService.atualizar(agendamento));
    }

    @GetMapping(path = "/{id}")
    @Operation(summary="Retorna um agendamento pelo codigo")
    public ResponseEntity<Agendamento> obterPorCodigo(@PathVariable String id){
        return ResponseEntity.ok().body(agendamentoService.obterPorId(id));
    }

    @GetMapping
    @Operation(summary="Retorna todos agendamento")
    public ResponseEntity<List<Agendamento>> obterTodos(){
        return ResponseEntity.ok().body(agendamentoService.obterTodos());
    }
}
