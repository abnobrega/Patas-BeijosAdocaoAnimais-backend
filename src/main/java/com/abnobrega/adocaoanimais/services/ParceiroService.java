package com.abnobrega.adocaoanimais.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abnobrega.adocaoanimais.domain.Parceiro;
import com.abnobrega.adocaoanimais.repositories.ParceiroRepository;
import com.abnobrega.adocaoanimais.services.exceptions.ObjectNotFoundException;

@Service
public class ParceiroService {
	
	@Autowired
	private ParceiroRepository parceiroRepository;
		
    //*********************************
    //******* C O N S U L T A R *******
    //*********************************		
	public Parceiro findById(Integer id) {
		Optional<Parceiro> obj = parceiroRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado! Id: " + id));		
	}

	public List<Parceiro> listarParceiros() {
		return parceiroRepository.findAll();
	}	
	
}
