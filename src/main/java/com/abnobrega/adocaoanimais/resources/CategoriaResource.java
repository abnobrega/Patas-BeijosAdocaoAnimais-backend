package com.abnobrega.adocaoanimais.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abnobrega.adocaoanimais.domain.Categoria;
import com.abnobrega.adocaoanimais.dtos.CategoriaDTO;
import com.abnobrega.adocaoanimais.services.CategoriaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController 							//Controlador Rest
@RequestMapping(value = "/api/categorias") 	//Para dicionar o endpoint inicial para os serviços(endpoints) das categorias
public class CategoriaResource {
	// Exemplo de Requisição Http para acessar um recurso de categoria: localhost:8080/api/categorias/1
	
	
    //*****************************************
    //**************  ATRIBUTOS  **************
    //*****************************************
	@Autowired
	private CategoriaService categoriaService;	
	
	
    //*************************************************
    //************** MÉTODOS / ENDPOINTS **************
    //*************************************************
	
    //*********************************
    //******* C O N S U L T A R *******
    //*********************************	
	// Endpoint para consultar uma Categoria por Id		
	@GetMapping(value = "/{id}")	
	@ApiOperation("Consultar Categoria por Id")	
	public ResponseEntity<CategoriaDTO> findById(@PathVariable @ApiParam("Id da categoria") Integer id) {
		Categoria obj = categoriaService.findById(id);
		return ResponseEntity.ok().body(new CategoriaDTO(obj));
	}
	
	// Endpoint para listar todas as categorias		
	@GetMapping		
	@ApiOperation("Listar Categorias")		
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		List<Categoria> lista = categoriaService.listarCategorias();
		List<CategoriaDTO> listaDTO = lista.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}

}
