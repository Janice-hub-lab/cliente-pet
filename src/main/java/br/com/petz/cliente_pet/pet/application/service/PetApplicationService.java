package br.com.petz.cliente_pet.pet.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.petz.cliente_pet.cliente.application.service.ClienteService;
import br.com.petz.cliente_pet.pet.application.api.PetClienteDetalheResponse;
import br.com.petz.cliente_pet.pet.application.api.PetRequest;
import br.com.petz.cliente_pet.pet.application.api.PetResponse;
import br.com.petz.cliente_pet.pet.application.api.petClienteListResponse;
import br.com.petz.cliente_pet.pet.domain.Pet;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class PetApplicationService implements PetService {
	private final ClienteService clienteService;
	private final PetRepository petRepository;

	@Override
	public PetResponse criaPet(UUID idCliente, @Valid PetRequest petRequest) {
		log.info("[start] PetApplicationService - criaPet");
		clienteService.buscaClienteAtravesId(idCliente);
		Pet pet = petRepository.salvaPet(new Pet(idCliente, petRequest));
		log.info("[finish] PetApplicationService - criaPet");
		return new PetResponse(pet.getIdPet());
	}

	@Override
	public List<petClienteListResponse> buscaPetsDoClienteComId(UUID idCliente) {
		log.info("[start] PetApplicationService - buscaPetsDoClienteComId");
		clienteService.buscaClienteAtravesId(idCliente);
		List<Pet> petsDoCliente = petRepository.buscaPetsDoClienteComId(idCliente);
		log.info("[finish] PetApplicationService - buscaPetsDoClienteComId ");
		return petClienteListResponse.converte(petsDoCliente);
	}

	@Override
	public PetClienteDetalheResponse buscaPetDoClienteComId(UUID idCliente, UUID idPet) {
		log.info("[start] PetApplicationService - buscaPetDoClienteComId");
		clienteService.buscaClienteAtravesId(idCliente);
		Pet pet = petRepository.buscaPetPeloId(idPet);
		log.info("[finish] PetApplicationService - buscaPetDoClienteComId");
		return new PetClienteDetalheResponse(pet);
	}

}
