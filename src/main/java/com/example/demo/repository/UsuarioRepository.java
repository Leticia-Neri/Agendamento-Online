package com.example.demo.repository;

import com.example.demo.models.UsuarioModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends MongoRepository<UsuarioModel, String> {

    public Optional<UsuarioModel> findByLogin(String login);
}