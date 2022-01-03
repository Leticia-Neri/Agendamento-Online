package com.example.demo.controller;

import com.example.demo.models.Endereco;
import com.example.demo.models.Paciente;
import com.example.demo.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @PostMapping("/salvarEndereco")
    public Endereco salvar(@RequestBody Endereco endereco){
        enderecoService.salvar(endereco);
        return endereco;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id){
        enderecoService.deletar(id);
        return ResponseEntity.noContent().build();
        //retorna 204, quando uma operação não retorna nada
    }

    @PutMapping(path = "/{id}")
    public Endereco atualizar(@PathVariable String id, @RequestBody Endereco endereco){
        return enderecoService.atualizar(endereco);
    }

    @GetMapping(path = "/{id}")
    public Endereco obterPorCodigo(@PathVariable String id){
        return enderecoService.obterPorId(id);
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> obterTodos(){
        return ResponseEntity.ok().body(enderecoService.obterTodos());
    }
}
