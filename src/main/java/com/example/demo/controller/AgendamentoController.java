package com.example.demo.controller;

import com.example.demo.dto.AgendamentoDTO;
import com.example.demo.exceptionHandler.ApiRequestException;
import com.example.demo.models.Agendamento;
import com.example.demo.models.Endereco;
import com.example.demo.models.Paciente;
import com.example.demo.repository.AgendamentoRepository;
import com.example.demo.service.AgendamentoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/agendamentos")
@CrossOrigin(origins = "*")
public class AgendamentoController {

    @Autowired
    AgendamentoService agendamentoService;

    @Autowired
    AgendamentoRepository agendamentoRepository;

    Logger log = Logger.getLogger("com.example.demo.controller");

    @PostMapping("/salvarAgendamento")
    @Operation(summary="Salva um agendamento")
    @ResponseStatus(HttpStatus.CREATED)
    public Agendamento salvar(@RequestBody @Valid AgendamentoDTO agendamentoDTO){

        Agendamento agendamento = agendamentoService.converAgendamentoDTO(agendamentoDTO);
        agendamentoService.salvar(agendamento);

        log.info("Agendamento salvo com sucesso retornando no corpo da requisicao o Agendamento e Status CREATED");
        return agendamento;
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary="Deleta um agendamento")
    public ResponseEntity<Void> deletar(@PathVariable String id){

        if(!agendamentoRepository.existsById(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        agendamentoService.deletar(id);

        log.info("Deletando agendamento e retornando status noContent");
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    @Operation(summary="Atualiza um agendamento")
    public ResponseEntity<Agendamento> atualizar(@PathVariable String id, @RequestBody AgendamentoDTO agendamentoDTO){

        Agendamento agendamento = agendamentoService.converAgendamentoDTO(agendamentoDTO);

        agendamento.setCodigo(id);
        agendamento = agendamentoService.atualizar(agendamento);

        log.info("Agendamendo atualizando e status ok");
        return ResponseEntity.ok().body(agendamento);
    }

    @GetMapping(path = "/{id}")
    @Operation(summary="Retorna um agendamento pelo codigo")
    public ResponseEntity<Agendamento> obterPorCodigo(@PathVariable String id){

        if (!agendamentoRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.info("Retornando agendamento no corpo da requisição e status ok");
        return ResponseEntity.ok().body(agendamentoService.obterPorId(id));
    }

    @GetMapping
    @Operation(summary="Retorna todos agendamento")
    public ResponseEntity<List<Agendamento>> obterTodos(){

        List<Agendamento> lista = agendamentoService.obterTodos();

        if(lista.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.info("Retornando todos agendamentos e status ok");
        return ResponseEntity.ok().body(agendamentoService.obterTodos());
    }
}
