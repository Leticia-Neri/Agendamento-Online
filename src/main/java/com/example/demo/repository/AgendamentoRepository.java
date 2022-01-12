package com.example.demo.repository;

import com.example.demo.models.Agendamento;
import com.example.demo.models.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends MongoRepository<Agendamento, String> {
}
