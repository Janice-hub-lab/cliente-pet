package br.com.petz.cliente_pet.pet.application.service;

import java.util.List;
import java.util.UUID;

import br.com.petz.cliente_pet.pet.application.api.PetRequest;
import br.com.petz.cliente_pet.pet.application.api.PetResponse;
import br.com.petz.cliente_pet.pet.application.api.petClienteListResponse;
import jakarta.validation.Valid;

public interface PetService {

	PetResponse criaPet(UUID idCliente, @Valid PetRequest petRequest);
	List<petClienteListResponse> buscaPetsDoClienteComId(UUID idCliente);

}
