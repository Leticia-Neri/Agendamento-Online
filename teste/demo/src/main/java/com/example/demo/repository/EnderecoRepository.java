package com.example.demo.repository;

import com.example.demo.models.Agendamento;
import com.example.demo.models.Endereco;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends MongoRepository<Endereco, String> {
}
