package br.com.petz.cliente_pet.cliente.application.api;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.petz.cliente_pet.cliente.domain.Sexo;
import lombok.Value;

@Value
public class ClienteDetalhadoResponse {
	private UUID idCliente;
	private String nomeCompleto;
	private String cpf;
	private String email;
	private String celular;
	private Sexo sexo;
	private Boolean aceitaTermos;	
	private LocalDateTime dataHoraDoCadastro;

}
