package com.example.demo.service;

import com.example.demo.exceptionHandler.ApiRequestException;
import com.example.demo.models.Paciente;
import com.example.demo.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService{

    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public Paciente salvar(Paciente paciente) {

        Optional<Paciente> pacienteCpf = pacienteRepository.findByCpf(paciente.getCpf());
        if(pacienteCpf.isPresent()){
            throw new RuntimeException("Paciente já cadastrado");
        }

        return pacienteRepository.save(paciente);
    }

    @Override
    public void deletar(String id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if(paciente.isEmpty()){
            throw new ApiRequestException("Paciente não encontrado");
        }

        pacienteRepository.deleteById(id);

    }

    @Override
    public Paciente atualizar(Paciente paciente) {
        Optional<Paciente> pacienteId = pacienteRepository.findById(paciente.getCodigo());
        if(pacienteId.isEmpty()){
            throw new RuntimeException("Paciente não encontrado");
        }
       return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente obterPorId(String id) {
        Optional<Paciente> pacienteId = pacienteRepository.findById(id);
        if(pacienteId.isEmpty()){
            throw new ApiRequestException("Paciente não Encontrado");
        }
        return pacienteRepository.findById(id).get();
    }

    @Override
    public List<Paciente> obterTodos() {
        return pacienteRepository.findAll();
    }


}
