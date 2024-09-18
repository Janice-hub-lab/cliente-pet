package br.com.petz.cliente_pet.pet.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.petz.cliente_pet.pet.application.service.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PetController implements PetAPI {

	private final PetService petService;

	@Override
	public PetResponse postPet(UUID idCliente, @Valid PetRequest petRequest) {
		log.info("[inicia] PetController - postPet");
		log.info("[idCliente] {}", idCliente);
		PetResponse pet = petService.criaPet(idCliente, petRequest);
		log.info("[finaliza] PetController - postPet");
		return pet;
	}

	@Override
	public List<petClienteListResponse> getPetsDoClienteComId(UUID idCliente, UUID idPet) {
		log.info("[inicia] PetController - getPetsDoClienteComId");
		log.info("[idCliente] {}", idCliente);
		List<petClienteListResponse> petsDoCliente = petService.buscaPetsDoClienteComId(idCliente);
		log.info("[finish] PetController - getPetsDoClienteComId");
		return petsDoCliente;
	}

	@Override
	public PetClienteDetalheResponse getPetDoClienteComId(UUID idCliente, UUID idPet) {
		log.info("[inicia] PetController - getPetDoClienteComId");
		log.info("[idCliente] {} - [idPet] {}", idCliente, idPet);
		PetClienteDetalheResponse pet = petService.buscaPetDoClienteComId(idCliente, idPet);
		log.info("[finish] PetController - getPetDoClienteComId");
		return pet;
	}

	@Override
	public void deletePetDoClienteComId(UUID idCliente, UUID idPet) {
		log.info("[inicia] PetController - deletePetDoClienteComId");
		log.info("[idCliente] {} - [idPet] {}", idCliente, idPet);
		petService.deletaPetDoClienteComId(idCliente, idPet);
		log.info("[finish] PetController - deletePetDoClienteComId");
	}

	@Override
	public PetResponse patchPet(UUID idCliente, UUID idPet, @Valid PetAlteracaoRequest petAlteracaoRequest) {
		log.info("[inicia] PetController - patchPet");
		log.info("[idCliente] {} - [idPet] {}", idCliente, idPet);
		log.info("[finish] PetController - patchPet");
		return null;
	}

}
