package com.example.demo.repository;

import com.example.demo.models.Agendamento;
import com.example.demo.models.Paciente;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendamentoRepository extends MongoRepository<Agendamento, String> {

    //List<Agendamento> findByEspecialidadeContaining(String text);

    @Query("{'especialidade' : { $regex: ?0, $options: 'i'}}")
    List<Agendamento> findByEspecialidade(String text);
}
