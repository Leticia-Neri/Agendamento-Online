package com.example.demo.controller;

import com.example.demo.models.Agendamento;
import com.example.demo.models.Paciente;
import com.example.demo.service.AgendamentoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Operation(summary="salva um agendamento")
    public Agendamento salvar(@RequestBody Agendamento agendamento){
        agendamentoService.salvar(agendamento);
        return agendamento;
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary="deleta um agendamento")
    public void deletar(@PathVariable String id){
        agendamentoService.deletar(id);
    }

    @PutMapping(path = "/{id}")
    @Operation(summary="atualiza um agendamento")
    public Agendamento atualizar(@PathVariable String id, @RequestBody Agendamento agendamento){
        return agendamentoService.atualizar(agendamento);
    }

    @GetMapping(path = "/{id}")
    @Operation(summary="retorna um agendamento pelo codigo")
    public Agendamento obterPorCodigo(@PathVariable String id){
        return agendamentoService.obterPorId(id);
    }

    @GetMapping
    @Operation(summary="retorna todos agendamento")
    public ResponseEntity<List<Agendamento>> obterTodos(){
        return ResponseEntity.ok().body(agendamentoService.obterTodos());
    }
}
