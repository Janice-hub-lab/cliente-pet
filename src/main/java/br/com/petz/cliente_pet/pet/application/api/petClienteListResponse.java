package br.com.petz.cliente_pet.pet.application.api;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.petz.cliente_pet.pet.domain.Pet;
import br.com.petz.cliente_pet.pet.domain.TipoPet;
import lombok.Getter;

@Getter
public class petClienteListResponse {
	private UUID idPet;
	private String nomePet;	
	private TipoPet tipo;
	private String raca;
	private String pelagemCor;
	private LocalDate dataNascimento;

	public static List<petClienteListResponse> converte(List<Pet> petsDoCliente) {
		return petsDoCliente.stream()
				.map(petClienteListResponse::new)
				.collect(Collectors.toList());
	}

	public petClienteListResponse(Pet pet) {
		super();
		this.idPet = pet.getIdPet();
		this.nomePet = pet.getNomePet();
		this.tipo = pet.getTipo();
		this.raca = pet.getRaca();
		this.pelagemCor = pet.getPelagemCor();
		this.dataNascimento = pet.getDataNascimento();
	}

}
