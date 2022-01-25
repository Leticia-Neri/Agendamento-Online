package com.example.demo.controller;

import com.example.demo.dto.AgendamentoDTO;
import com.example.demo.exceptionHandler.ApiRequestException;
import com.example.demo.models.Agendamento;
import com.example.demo.models.Endereco;
import com.example.demo.models.Paciente;
import com.example.demo.repository.AgendamentoRepository;
import com.example.demo.service.AgendamentoService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agendamentos")
@CrossOrigin(origins = "*")
public class AgendamentoController {

    @Autowired
    AgendamentoService agendamentoService;

    @Autowired
    AgendamentoRepository agendamentoRepository;

    private static final Logger log = LoggerFactory.getLogger(AgendamentoController.class);

    @PostMapping("/salvarAgendamento")
    @Operation(summary="Salva um agendamento")
    @ResponseStatus(HttpStatus.CREATED)
    public Agendamento salvar(@RequestBody @Valid AgendamentoDTO agendamentoDTO){

        log.info("Entrando no método salvar agendamento");
        Agendamento agendamento = agendamentoService.converAgendamentoDTO(agendamentoDTO);

        log.info("Salvando agendamento");
        agendamentoService.salvar(agendamento);

        log.info("Agendamento salvo com sucesso retornando no corpo da requisicao o Agendamento e Status CREATED");
        return agendamento;
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary="Deleta um agendamento")
    public ResponseEntity<Void> deletar(@PathVariable String id){

        log.info("Entrando no método deletar agendamento \r\n Verificando se agendamento de id : {} existe no banco de dados", id);
        if(!agendamentoRepository.existsById(id)){
            log.info("Agendamento não encontrado");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.info("Deletando agendamanto");
        agendamentoService.deletar(id);

        log.info("Retornando status noContent");
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    @Operation(summary="Atualiza um agendamento")
    public ResponseEntity<Agendamento> atualizar(@PathVariable String id, @RequestBody AgendamentoDTO agendamentoDTO){

        log.info("Entrando no método deatualizar agendamento");
        Agendamento agendamento = agendamentoService.converAgendamentoDTO(agendamentoDTO);

        agendamento.setCodigo(id);

        log.info("Atualizando agedendamento de id : {}", id);
        agendamento = agendamentoService.atualizar(agendamento);

        log.info("Retornado agendamendo atualizando e status ok");
        return ResponseEntity.ok().body(agendamento);
    }

    @GetMapping(path = "/{id}")
    @Operation(summary="Retorna um agendamento pelo codigo")
    public ResponseEntity<Agendamento> obterPorCodigo(@PathVariable String id){

        log.info("Entrando no metódo deletar agendamento pelo codigo \r\n Buscando agendamento por id : {} no banco de dados", id);
        if (!agendamentoRepository.existsById(id)) {
            log.info("Agendamento não encontrado");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.info("Retornando agendamento no corpo da requisição e status ok");
        return ResponseEntity.ok().body(agendamentoService.obterPorId(id));
    }

    @GetMapping
    @Operation(summary="Retorna todos agendamento")
    public ResponseEntity<List<Agendamento>> obterTodos(){

        log.info("Entrando no metódo obter todos agendamentos \r\n Buscando agendamento no banco de dados");
        List<Agendamento> lista = agendamentoService.obterTodos();

        log.info("Verificando se existe agendamentos no banco de dados");
        if(lista.isEmpty()){

            log.info("Lista de agendamento vazia e retorno not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.info("Retornando todos agendamentos e status ok");
        return ResponseEntity.ok().body(agendamentoService.obterTodos());
    }
}
