package com.abnobrega.adocaoanimais.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abnobrega.adocaoanimais.domain.Parceiro;
import com.abnobrega.adocaoanimais.dtos.ParceiroDTO;
import com.abnobrega.adocaoanimais.services.ParceiroService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController 							//Controlador Rest
@RequestMapping(value = "/api/parceiros") 	//Para dicionar o endpoint inicial para os serviços(endpoints) dos parceiros
public class ParceiroResource {
	// Exemplo de Requisição Http para acessar um recurso de parceiro: localhost:8080/api/parceiros/1
	
	
    //*****************************************
    //**************  ATRIBUTOS  **************
    //*****************************************
	@Autowired
	private ParceiroService parceiroService;	
	
    //*************************************************
    //************** MÉTODOS / ENDPOINTS **************
    //*************************************************
	
    //*********************************
    //******* C O N S U L T A R *******
    //*********************************	
	// Endpoint para consultar um Parceiro por Id			
	@GetMapping(value = "/{id}")	
	@ApiOperation("Consultar Parceiro por Id")	
	public ResponseEntity<ParceiroDTO> findById(@PathVariable @ApiParam("Id do parceiro") Integer id) {
		Parceiro obj = parceiroService.findById(id);
		return ResponseEntity.ok().body(new ParceiroDTO(obj));
	}
	
	// Endpoint para listar todos os parceiros	
	@GetMapping
	@ApiOperation("Listar Parceiros")		
	public ResponseEntity<List<ParceiroDTO>> findAll(){
		List<Parceiro> lista = parceiroService.listarParceiros();		
		List<ParceiroDTO> listaDTO = lista.stream().map(obj -> new ParceiroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}	

}
