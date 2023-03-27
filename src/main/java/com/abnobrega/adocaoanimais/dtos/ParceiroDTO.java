package com.abnobrega.adocaoanimais.dtos;

import java.io.Serializable;

import com.abnobrega.adocaoanimais.domain.Parceiro;

public class ParceiroDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// *************************
	// ******* ATRIBUTOS *******
	// *************************	
	private Integer id;
	private String nome;
	private String descricao;
	
	//**************************
	//******* CONSTRUTOR *******
	//**************************	
	public ParceiroDTO() {
		super();
	}

	//*************************
	//*******  MÉTODOS  *******
	//*************************	
	public ParceiroDTO(Parceiro obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
