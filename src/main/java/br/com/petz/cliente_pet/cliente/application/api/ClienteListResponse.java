package br.com.petz.cliente_pet.cliente.application.api;

import java.util.List;
import java.util.UUID;

import br.com.petz.cliente_pet.cliente.domain.Cliente;
import jakarta.validation.constraints.NotBlank;

public class ClienteListResponse {
	private UUID idCliente;
	private String nomeCompleto;
	private String cpf;
	private String email;
	private String celular;
	
	
	public static List<ClienteListResponse> converte(List<Cliente> clientes) {
		return null;
	}

}
