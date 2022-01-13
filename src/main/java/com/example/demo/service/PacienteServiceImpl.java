package com.example.demo.service;

import com.example.demo.dto.PacienteDTO;
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
            throw new ApiRequestException("Paciente já cadastrado");
        }

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

    @Override
    public PacienteDTO convertePaciente(Paciente paciente) {


        PacienteDTO pacienteDTO = new PacienteDTO();

        pacienteDTO.setCodigo(paciente.getCodigo());
        pacienteDTO.setNome(paciente.getNome());
        pacienteDTO.setSobrenome(paciente.getSobrenome());
        pacienteDTO.setSexo(paciente.getSexo());
        pacienteDTO.setEndereco(paciente.getEndereco());
        pacienteDTO.setCpf(paciente.getCpf());
        pacienteDTO.setDataNasc(paciente.getDataNasc());
        pacienteDTO.setTelefone(paciente.getTelefone());
        return pacienteDTO;
    }

    @Override
    public Paciente convertPacienteDto(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente();
        paciente.setCodigo(pacienteDTO.getCodigo());
        paciente.setNome(pacienteDTO.getNome());
        paciente.setSobrenome(pacienteDTO.getSobrenome());
        paciente.setSexo(pacienteDTO.getSexo());
        paciente.setEndereco(pacienteDTO.getEndereco());
        paciente.setCpf(pacienteDTO.getCpf());
        paciente.setDataNasc(pacienteDTO.getDataNasc());
        paciente.setTelefone(pacienteDTO.getTelefone());
        return paciente;
    }


}
