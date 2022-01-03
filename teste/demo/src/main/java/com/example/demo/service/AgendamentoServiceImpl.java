package com.example.demo.service;

import com.example.demo.models.Agendamento;
import com.example.demo.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoServiceImpl implements AgendamentoService{

    @Autowired
    AgendamentoRepository agendamentoRepository;

    @Override
    public Agendamento salvar(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    @Override
    public void deletar(String id) {
        agendamentoRepository.deleteById(id);
    }

    @Override
    public Agendamento atualizar(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    @Override
    public Agendamento obterPorId(String id) {
        return agendamentoRepository.findById(id).get();
    }

    @Override
    public List<Agendamento> obterTodos() {
        return agendamentoRepository.findAll();
    }
}
