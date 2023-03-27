package com.abnobrega.adocaoanimais.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
/*
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
*/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abnobrega.adocaoanimais.domain.Animal;
import com.abnobrega.adocaoanimais.dtos.AnimalDTO;
//import com.abnobrega.adocaoanimais.domain.Animal;
import com.abnobrega.adocaoanimais.services.AnimalService;

@RestController 							//Controlador Rest
@RequestMapping(value = "/api/animais") 	//Para dicionar o endpoint inicial para os serviços(endpoints) dos animai
public class AnimalResource {
	// Exemplo de Requisição Http para acessar um recurso de animal: localhost:8080/api/animais/1
	
	
    //*****************************************
    //**************  ATRIBUTOS  **************
    //*****************************************
	@Autowired
	private AnimalService animalService;	
	
    //*************************************************
    //************** MÉTODOS / ENDPOINTS **************
    //*************************************************
	
    //*********************************
    //******* C O N S U L T A R *******
    //*********************************	
	@GetMapping(value = "/{id}")	// Recebo um um pathvariable id	
	public ResponseEntity<Animal> findById(@PathVariable Integer id) {
		Animal obj = animalService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<AnimalDTO>> findAll() {
		List<Animal> lista = animalService.listarAnimais();
		List<AnimalDTO> listaDTO = lista.stream().map(obj -> new AnimalDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
		
	}	
	
    //*********************************
    //******* A T U A L I Z A R *******
    //*********************************		
	@PutMapping(value = "/{id}")	// Recebo um um PathVariable id
	public ResponseEntity<AnimalDTO> atualizarAnimal(@PathVariable Integer id, 
													 @RequestBody AnimalDTO objDTO) {
		Animal newObj = animalService.atualizarAnimal(id, objDTO);
		
		return ResponseEntity.ok().body(new AnimalDTO(newObj));
	}

}
