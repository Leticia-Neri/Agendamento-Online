package com.example.demo.controller;

import com.example.demo.models.Agendamento;
import com.example.demo.models.Paciente;
import com.example.demo.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    AgendamentoService agendamentoService;

    @PostMapping("/salvarAgendamento")
    public Agendamento salvar(@RequestBody Agendamento agendamento){
        agendamentoService.salvar(agendamento);
        return agendamento;
    }

    @DeleteMapping(path = "/{id}")
    public void deletar(@PathVariable String id){
        agendamentoService.deletar(id);
    }

    @PutMapping(path = "/{id}")
    public Agendamento atualizar(@PathVariable String id, @RequestBody Agendamento agendamento){
        return agendamentoService.atualizar(agendamento);
    }

    @GetMapping(path = "/{id}")
    public Agendamento obterPorCodigo(@PathVariable String id){
        return agendamentoService.obterPorId(id);
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> obterTodos(){
        return ResponseEntity.ok().body(agendamentoService.obterTodos());
    }
}
