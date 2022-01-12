package com.example.demo.repository;

import com.example.demo.models.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Agendamento;

import java.util.Optional;

@Repository
public interface PacienteRepository extends MongoRepository<Paciente, String> {

    Optional<Paciente> findByCpf(String cpf);
}