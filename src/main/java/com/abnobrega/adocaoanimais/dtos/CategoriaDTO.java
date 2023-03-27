package com.abnobrega.adocaoanimais.dtos;

import java.io.Serializable;

import com.abnobrega.adocaoanimais.domain.Categoria;

public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// *************************
	// ******* ATRIBUTOS *******
	// *************************
	private Integer id;
	private String descricao;
	
	//**************************
	//******* CONSTRUTOR *******
	//**************************	
	public CategoriaDTO() {
		super();
	}

	public CategoriaDTO(Categoria obj) {
		super();
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
	}

	//*************************
	//*******  MÉTODOS  *******
	//*************************		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
