package br.com.petz.cliente_pet.cliente.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.validator.constraints.br.CPF;

import br.com.petz.cliente_pet.cliente.application.api.ClienteAlteracaoRequest;
import br.com.petz.cliente_pet.cliente.application.api.ClienteRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "idCliente", updatable = false, unique = true, nullable = false)
	private UUID idCliente;
	@NotBlank
	private String nomeCompleto;
	@NotBlank
	@Email
	@Column(unique = true)
	private String email;
	@NotBlank
	private String celular;
	private String telefone;
	private Sexo sexo;
	@NotNull
	private LocalDate dataNascimento;
	@CPF
	@Column(unique = true)
	private String cpf;
	@NotNull
	private Boolean aceitaTermos;
	
	private LocalDateTime dataHoraCadastro;
	private LocalDateTime dataHoraDaUltimaAlteracao;
	
	public Cliente(ClienteRequest clienteRequest) {
		this.nomeCompleto = clienteRequest.getNomeCompleto();
		this.email = clienteRequest.getEmail();
		this.celular = clienteRequest.getCelular();
		this.telefone = clienteRequest.getTelefone();
		this.sexo = clienteRequest.getSexo();
		this.dataNascimento = clienteRequest.getDataNascimento();
		this.cpf = clienteRequest.getCpf();
		this.aceitaTermos = clienteRequest.getAceitaTermos();
		this.dataHoraCadastro = LocalDateTime.now();
	}

	public void altera(@Valid ClienteAlteracaoRequest clienteAlteracaoRequest) {
		this.nomeCompleto = clienteAlteracaoRequest.getNomeCompleto();
		this.celular = clienteAlteracaoRequest.getCelular();
		this.telefone = clienteAlteracaoRequest.getTelefone();
		this.sexo = clienteAlteracaoRequest.getSexo();
		this.dataNascimento = clienteAlteracaoRequest.getDataNascimento();
		this.aceitaTermos = clienteAlteracaoRequest.getAceitaTermos();
		this.dataHoraDaUltimaAlteracao = LocalDateTime.now();
		
	}
	
	
	
	
	
	

}
