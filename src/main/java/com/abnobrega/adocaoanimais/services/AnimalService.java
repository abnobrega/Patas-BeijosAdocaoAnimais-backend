package com.abnobrega.adocaoanimais.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abnobrega.adocaoanimais.domain.Animal;
import com.abnobrega.adocaoanimais.domain.Categoria;
import com.abnobrega.adocaoanimais.domain.Parceiro;
import com.abnobrega.adocaoanimais.domain.enums.Status;
import com.abnobrega.adocaoanimais.dtos.AnimalDTO;
import com.abnobrega.adocaoanimais.repositories.AnimalRepository;
import com.abnobrega.adocaoanimais.services.exceptions.ObjectNotFoundException;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private ParceiroService parceiroService;
		
    //*********************************
    //******* C O N S U L T A R *******
    //*********************************		
	public Animal findById(Integer id) {
		Optional<Animal> obj = animalRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado! Id: " + id));
	}
	
	public List<Animal> listarAnimais() {
		return animalRepository.findAll();
	}
	
    //*********************************
    //******* A T U A L I Z A R *******
    //*********************************
	public Animal atualizarAnimal(Integer id, AnimalDTO objDTO) {	
		//objDTO.setId(id); 						// Pra garantir que o objDTO tenha o id correto 
		Animal objAtualizado = findById(id); 	//Verifica se o existe no BD o Chamado com o id passado na URL
		objAtualizado = gerarNovoAnimal(objDTO);
		return animalRepository.save(objAtualizado);
	}
	
	private Animal gerarNovoAnimal(AnimalDTO objDTO) {
		// Verificar se existe o id da Categoria que veio no parâmetro objDTO.		
		Categoria categoria = categoriaService.findById(objDTO.getIdCategoria());
		
		// Verificar se existe o id do Parceiro que veio no parâmetro objDTO.
		Parceiro parceiro = parceiroService.findById(objDTO.getIdParceiro());
		
		Animal animal = new Animal();
		
		if (objDTO.getId() != null) {
			animal.setId(objDTO.getId());
		}
		
		// Atribui os valores atualizados do animal
		animal.setNome(objDTO.getNome());
		animal.setDescricao(objDTO.getDescricao());
		animal.setStatus(Status.toEnum(objDTO.getIdStatusAnimal())); 
		animal.setCategoria(categoria);
		animal.setParceiro(parceiro);	
		
		return animal;
	}
}
