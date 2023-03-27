package com.abnobrega.adocaoanimais.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abnobrega.adocaoanimais.domain.Categoria;
import com.abnobrega.adocaoanimais.repositories.CategoriaRepository;
import com.abnobrega.adocaoanimais.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
		
    //*********************************
    //******* C O N S U L T A R *******
    //*********************************		
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado! Id: " + id));		
	}
	
	public List<Categoria> listarCategorias() {
		return categoriaRepository.findAll();
	}

}
