package com.abnobrega.adocaoanimais.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Parceiro implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//*************************
	//******* ATRIBUTOS *******
	//*************************		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	
    @Column(length = 45, nullable = false)    	
	private String nome;
	
    @Column(length = 100, nullable = false)    	
	private String descricao;

	// PARCEIRO 1:n ANIMAL 	
	@JsonIgnore
	@OneToMany(mappedBy = "parceiro") 	
	private List<Animal> animais = new ArrayList<>();
	
	//**************************
	//******* CONSTRUTOR *******
	//**************************
	public Parceiro() {
		super();
	}

	public Parceiro(Integer id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
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

	public List<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parceiro other = (Parceiro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
