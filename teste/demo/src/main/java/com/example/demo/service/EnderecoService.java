package com.example.demo.service;

import com.example.demo.models.Agendamento;
import com.example.demo.models.Endereco;

import java.util.List;

public interface EnderecoService {

    Endereco salvar(Endereco endereco);

    void deletar(String id);

    Endereco atualizar(Endereco endereco);

    Endereco obterPorId(String id);

    List<Endereco> obterTodos();
}
