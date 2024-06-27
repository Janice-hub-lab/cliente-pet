package br.com.petz.cliente_pet.cliente.application.api;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public class ClienteListResponse {
	private UUID idCliente;
	private String nomeCompleto;
	private String cpf;
	private String email;
	private String celular;

}
