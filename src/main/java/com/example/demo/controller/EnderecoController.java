package com.example.demo.controller;

import com.example.demo.dto.EnderecoDTO;
import com.example.demo.models.Endereco;
import com.example.demo.models.Paciente;
import com.example.demo.repository.EnderecoRepository;
import com.example.demo.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/enderecos")
@CrossOrigin(origins = "*")
public class EnderecoController {

    Logger log = Logger.getLogger("com.example.demo.controller");

    @Autowired
    EnderecoService enderecoService;

    @Autowired
    EnderecoRepository enderecoRepository;

    @PostMapping("/salvarEndereco")
    @Operation(summary="Salva um endereço")
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco salvar(@Valid @RequestBody EnderecoDTO enderecoDTO){

        Endereco endereco = enderecoService.convertEnderecoDto(enderecoDTO);

        log.info("Endereço salvo com sucesso retornando no corpo da requisicao o Endereço e Status CREATED");
        enderecoService.salvar(endereco);
        return endereco;
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary="Deletar um endereco")
    public ResponseEntity<Void> deletar(@PathVariable String id){

        if(!enderecoRepository.existsById(id)){
            log.info("Endereço não encontrado");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        enderecoService.deletar(id);

        log.info("Deletando agendamento e retornando status noContent");
        return ResponseEntity.noContent().build();

    }

    @PutMapping(path = "/{id}")
    @Operation(summary="Atualizar um endereço")
    public ResponseEntity<Endereco> atualizar(@PathVariable String id, @RequestBody EnderecoDTO enderecoDTO){

        Endereco endereco = enderecoService.convertEnderecoDto(enderecoDTO);

        endereco.setCodigo(id);
        endereco = enderecoService.atualizar(endereco);

        log.info("Agendamendo atualizando e status ok");
        return ResponseEntity.ok(endereco);
    }

    @GetMapping(path = "/{id}")
    @Operation(summary="Retornar um endereço por codigo")
    public ResponseEntity<Endereco> obterPorCodigo(@PathVariable String id){

        if (!enderecoRepository.existsById(id)) {
            log.info("Endereço não encontrado retorno not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.info("Retornando agendamento no corpo da requisição e status ok");
        return ResponseEntity.ok(enderecoService.obterPorId(id));
    }

    @GetMapping
    @Operation(summary="Retornar todos os endereços")
    public ResponseEntity<List<Endereco>> obterTodos(){

        List<Endereco> lista = enderecoService.obterTodos();

        if(lista.isEmpty()){
            log.info("Lista de endereço vazia e retorno not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.info("Retornando endereços e status ok");
        return ResponseEntity.ok().body(enderecoService.obterTodos());
    }
}
