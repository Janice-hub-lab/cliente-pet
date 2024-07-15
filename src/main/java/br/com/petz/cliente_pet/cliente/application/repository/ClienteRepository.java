package br.com.petz.cliente_pet.cliente.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.petz.cliente_pet.cliente.domain.Cliente;

public interface ClienteRepository {
	Cliente salva(Cliente cliente);
	List<Cliente> buscaTodosClientes();
	Cliente buscaClienteAtravesId(UUID idCliente);
	List<Cliente> buscaTodosCliente();
	

	
}
