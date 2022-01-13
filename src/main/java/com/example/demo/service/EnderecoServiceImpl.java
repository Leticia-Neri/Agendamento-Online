package com.example.demo.service;

import com.example.demo.dto.EnderecoDTO;
import com.example.demo.dto.PacienteDTO;
import com.example.demo.exceptionHandler.ApiRequestException;
import com.example.demo.models.Endereco;
import com.example.demo.models.Paciente;
import com.example.demo.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoServiceImpl implements EnderecoService{

    @Autowired
    EnderecoRepository enderecoRepository;

    @Override
    public Endereco salvar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public void deletar(String id) {
        /*
        Optional<Endereco> endereco = enderecoRepository.findById(id);

        if(endereco.isEmpty()){
            throw new ApiRequestException("Endereço não encontrado");
        }*/
        enderecoRepository.deleteById(id);
    }

    @Override
    public Endereco atualizar(Endereco endereco) {

        /*
        Optional<Endereco> enderecoid = enderecoRepository.findById(endereco.getCodigo());
        if(enderecoid.isEmpty()){
            throw new RuntimeException("Endereço não encontrado");
        }
        */
        return enderecoRepository.save(endereco);
    }

    @Override
    public Endereco obterPorId(String id) {
        /*
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        if(endereco.isEmpty()){
            throw new ApiRequestException("Endereço não encontrado");
        }*/

        return enderecoRepository.findById(id).get();
    }

    @Override
    public List<Endereco> obterTodos() {
        return enderecoRepository.findAll();
    }

    @Override
    public EnderecoDTO convertEndereco(Endereco endereco) {

        EnderecoDTO enderecoDTO = new EnderecoDTO();

        enderecoDTO.setEstado(endereco.getEstado());
        enderecoDTO.setCidade(endereco.getCidade());
        enderecoDTO.setBairro(endereco.getBairro());
        enderecoDTO.setRua(endereco.getRua());
        enderecoDTO.setNumero(endereco.getNumero());
        enderecoDTO.setCep(endereco.getCep());
        enderecoDTO.setComplemento(endereco.getComplemento());

        return enderecoDTO;

    }

    @Override
    public Endereco convertEnderecoDto(EnderecoDTO enderecoDTO) {

        Endereco endereco = new Endereco();

        endereco.setEstado(enderecoDTO.getEstado());
        endereco.setCidade(enderecoDTO.getCidade());
        endereco.setBairro(enderecoDTO.getBairro());
        endereco.setRua(enderecoDTO.getRua());
        endereco.setNumero(enderecoDTO.getNumero());
        endereco.setCep(enderecoDTO.getCep());
        endereco.setComplemento(enderecoDTO.getComplemento());

        return endereco;
    }
}
