package com.example.demo.service;

import com.example.demo.models.Agendamento;
import com.example.demo.models.Paciente;

import java.util.List;

public interface AgendamentoService {

    Agendamento salvar(Agendamento agendamento);

    void deletar(String id);

    Agendamento atualizar(Agendamento agendamento);

    Agendamento obterPorId(String id);

    List<Agendamento > obterTodos();
}
