package com.example.demo.controller;

import com.example.demo.dto.EnderecoDTO;
import com.example.demo.models.Endereco;
import com.example.demo.models.Paciente;
import com.example.demo.repository.EnderecoRepository;
import com.example.demo.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/enderecos")
@CrossOrigin(origins = "*")
public class EnderecoController {

    private static final Logger log = LoggerFactory.getLogger(EnderecoController.class);

    @Autowired
    EnderecoService enderecoService;

    @Autowired
    EnderecoRepository enderecoRepository;

    @PostMapping("/salvarEndereco")
    @Operation(summary="Salva um endereço")
    @ResponseStatus(HttpStatus.CREATED)
    @Secured({"ROLE_ADMIN"})
    public Endereco salvar(@Valid @RequestBody EnderecoDTO enderecoDTO){

        log.info("Entrando no metódo salvar endereco");
        Endereco endereco = enderecoService.convertEnderecoDto(enderecoDTO);

        log.info("Endereço salvo com sucesso retornando no corpo da requisicao o Endereço e Status CREATED");
        enderecoService.salvar(endereco);
        return endereco;
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary="Deletar um endereco")
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<Void> deletar(@PathVariable String id){

        log.info("Entrando no metódo deletar endereço pelo codigo \r\n Buscando endereco por id : {} no banco de dados", id);
        if(!enderecoRepository.existsById(id)){
            log.info("Endereço não encontrado");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        enderecoService.deletar(id);

        log.info("Deletando endereço de id : {} e retornando status noContent", id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping(path = "/{id}")
    @Operation(summary="Atualizar um endereço")
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<Endereco> atualizar(@PathVariable String id, @RequestBody EnderecoDTO enderecoDTO){

        log.info("Entrando no metódo atualizar endereço pelo codigo");
        Endereco endereco = enderecoService.convertEnderecoDto(enderecoDTO);

        endereco.setCodigo(id);
        log.info("Atualizando enderço");
        endereco = enderecoService.atualizar(endereco);

        log.info("Retornando endereço e status ok");
        return ResponseEntity.ok(endereco);
    }

    @GetMapping(path = "/{id}")
    @Operation(summary="Retornar um endereço por codigo")
    public ResponseEntity<Endereco> obterPorCodigo(@PathVariable String id){

        log.info("Entrando no metódo obter endreços pelo codigo \r\n Buscando endereço por id no banco de dados");
        if (!enderecoRepository.existsById(id)) {
            log.info("Endereço de id : {} não encontrado retorno not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.info("Retornando agendamento no corpo da requisição e status ok");
        return ResponseEntity.ok(enderecoService.obterPorId(id));
    }

    @GetMapping
    @Operation(summary="Retornar todos os endereços")
    public ResponseEntity<List<Endereco>> obterTodos(){

        log.info("Entrando no metódo obter todos endereços \r\n Buscando todos endereços no banco de dados");
        List<Endereco> lista = enderecoService.obterTodos();

        log.info("Verificando se existe endereços no banco de dados");
        if(lista.isEmpty()){
            log.info("Lista de endereço vazia e retorno not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.info("Retornando endereços e status ok");
        return ResponseEntity.ok().body(enderecoService.obterTodos());
    }
    @GetMapping("/userInfo")
    public UserDetails userInfo(@AuthenticationPrincipal UserDetails user){
        return user;
    }
}
