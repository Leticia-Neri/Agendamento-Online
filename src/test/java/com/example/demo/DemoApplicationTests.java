package com.example.demo;


import com.example.demo.exceptionHandler.ApiRequestException;
import com.example.demo.models.Paciente;
import com.example.demo.repository.PacienteRepository;
import com.example.demo.service.PacienteService;
import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class CadastroPacienteIntegrationTests {

	@Autowired
	PacienteService pacienteService;

	@Test
	@DisplayName("Deve criar um livro com sucesso")
	public void DeveCadastroPacienteComSucesso() {
		Paciente paciente = new Paciente();
		paciente.setCpf("745");
		paciente.setNome("Fábia");
		paciente.setSexo("Feminino");
		paciente.setDataNasc("09/06/1975");
		paciente.setTelefone("1");

		pacienteService.salvar(paciente);

		Assertions.assertThat(paciente.getCpf()).isNotEmpty();
	}

	@Test
	public void DeveDeletarPacienteComSucesso(){

		pacienteService.deletar("61dc8ff83b5a6442bf350b83");
	}


	@Test()
	public void NaodeveCadastrarPacienteComMesmoCpf(){

		Paciente paciente = new Paciente();
		paciente.setCpf("758");

       org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class, () -> pacienteService.salvar(paciente));

	}

}