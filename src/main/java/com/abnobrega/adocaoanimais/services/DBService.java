package com.abnobrega.adocaoanimais.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abnobrega.adocaoanimais.domain.Animal;
import com.abnobrega.adocaoanimais.domain.Categoria;
import com.abnobrega.adocaoanimais.domain.Parceiro;
import com.abnobrega.adocaoanimais.domain.enums.Status;
import com.abnobrega.adocaoanimais.repositories.AnimalRepository;
import com.abnobrega.adocaoanimais.repositories.CategoriaRepository;
import com.abnobrega.adocaoanimais.repositories.ParceiroRepository;

@Service
public class DBService {
	
	// Injetando dependências das interfaces abaixo:
	@Autowired 
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ParceiroRepository parceiroRepository;
	
	@Autowired 
	private AnimalRepository animaRepository;	
	
	public void instanciaDB() {
		Categoria categoria1 = new Categoria(null, "GATO");
		Categoria categoria2 = new Categoria(null, "CACHORRO");		
		
		Parceiro parceiro1 = new Parceiro(null, "Suely", "Parceira de adoção de teste 1");
		Parceiro parceiro2 = new Parceiro(null, "Karla", "Parceira de adoção de teste 2");		
		Parceiro parceiro3 = new Parceiro(null, "Paulinho", "Parceira de adoção de teste 3");		
		
		Animal animal1 = new Animal(null, "Tiutiuquinha", "Gata da Suely", Status.ADOTADO, categoria1, parceiro1);

		Animal animal2 = new Animal(null, "Fredinho", "Gatinho da Karla", Status.DISPONIVEL, categoria1, parceiro2);
		
		Animal animal3 = new Animal(null, "Lucky", "Cachorro do Paulinho", Status.ADOTADO, categoria2, parceiro3);
		
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		parceiroRepository.saveAll(Arrays.asList(parceiro1, parceiro2, parceiro3));	
		animaRepository.saveAll(Arrays.asList(animal1, animal2, animal3));			
	}

}
