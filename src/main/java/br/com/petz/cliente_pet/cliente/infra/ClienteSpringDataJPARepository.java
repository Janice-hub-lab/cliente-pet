package br.com.petz.cliente_pet.cliente.infra;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.petz.cliente_pet.cliente.domain.Cliente;

public interface ClienteSpringDataJPARepository extends JpaRepository<Cliente, UUID>  {

	Optional<Cliente> findByIdCliente(UUID idCliente);

}
