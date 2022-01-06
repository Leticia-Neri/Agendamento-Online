package com.example.demo.controller;

import com.example.demo.models.Endereco;
import com.example.demo.models.Paciente;
import com.example.demo.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
@CrossOrigin(origins = "*")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @PostMapping("/salvarEndereco")
    @Operation(summary="Salva um endereço")
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco salvar(@RequestBody Endereco endereco){
        enderecoService.salvar(endereco);
        return endereco;
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary="Deletar um endereco")
    public ResponseEntity<Void> deletar(@PathVariable String id){
        enderecoService.deletar(id);
        //retorna 204, quando uma operação não retorna nada
        return ResponseEntity.noContent().build();

    }

    @PutMapping(path = "/{id}")
    @Operation(summary="Atualizar um agendamento")
    public ResponseEntity<Endereco> atualizar(@PathVariable String id, @RequestBody Endereco endereco){
        return ResponseEntity.ok(enderecoService.atualizar(endereco));
    }

    @GetMapping(path = "/{id}")
    @Operation(summary="Retornar um endereço por codigo")
    public ResponseEntity<Endereco> obterPorCodigo(@PathVariable String id){
        return ResponseEntity.ok(enderecoService.obterPorId(id));
    }

    @GetMapping
    @Operation(summary="Retornar todos os endereços")
    public ResponseEntity<List<Endereco>> obterTodos(){
        return ResponseEntity.ok().body(enderecoService.obterTodos());
    }
}
