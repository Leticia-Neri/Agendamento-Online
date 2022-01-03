package com.example.demo.service;

import com.example.demo.models.Paciente;
import com.example.demo.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService{

    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public Paciente salvar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public void deletar(String id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Paciente atualizar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente obterPorId(String id) {
        return pacienteRepository.findById(id).get();
    }

    @Override
    public List<Paciente> obterTodos() {
        return pacienteRepository.findAll();
    }


}
