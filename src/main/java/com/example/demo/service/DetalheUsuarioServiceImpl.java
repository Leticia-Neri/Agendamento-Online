package com.example.demo.service;

import com.example.demo.jwt.data.DetalheUsuarioData;
import com.example.demo.models.UsuarioModel;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DetalheUsuarioServiceImpl implements UserDetailsService {


    private final UsuarioRepository repository;

    public DetalheUsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsuarioModel> usuario = repository.findByLogin(username);
        if(username.isEmpty()){
            throw new UsernameNotFoundException("Usuario ["+ username + "] não encontrado");
        }

        return new DetalheUsuarioData(usuario,usuario.get().getRole());
    }
}