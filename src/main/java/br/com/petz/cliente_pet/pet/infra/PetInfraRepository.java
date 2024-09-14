package br.com.petz.cliente_pet.pet.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.petz.cliente_pet.handler.APIException;
import br.com.petz.cliente_pet.pet.application.service.PetRepository;
import br.com.petz.cliente_pet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PetInfraRepository implements PetRepository {
	private final PetSpringDataJPARepository petSpringDataJARepository;

	@Override
	public Pet salvaPet(Pet pet) {
		log.info("[start] PetInfraRepository - salvaPet");
		petSpringDataJARepository.save(pet);
		log.info("[finish] PetInfraRepository - salvaPet");
		return pet;
	}

	@Override
	public List<Pet> buscaPetsDoClienteComId(UUID idCliente) {
		log.info("[start] PetInfraRepository - buscaPetsDoClienteComId");
		var pets = petSpringDataJARepository.findByIdClienteTutor(idCliente);
		log.info("[finish] PetInfraRepository - buscaPetsDoClienteComId");
		return pets;
	}

	@Override
	public Pet buscaPetPeloId(UUID idPet) {
		log.info("[start] PetInfraRepository - buscaPetPeloId");
		var pet = petSpringDataJARepository.findById(idPet)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Pet não encontrado para o id = " + idPet));
		log.info("[finish] PetInfraRepository - buscaPetPeloId");
		return pet;
	}

}
