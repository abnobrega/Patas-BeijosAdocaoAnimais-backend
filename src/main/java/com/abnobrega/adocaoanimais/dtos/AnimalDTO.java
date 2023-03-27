package com.abnobrega.adocaoanimais.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.abnobrega.adocaoanimais.domain.Animal;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AnimalDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//*************************
	//******* ATRIBUTOS *******
	//*************************		
	private Integer id;
	private String nome;
	private String descricao;

	//private Status status;
	private Integer idStatusAnimal;	
	private String descStatusAnimal;	

	//private Categoria categoria;
	private Integer idCategoria;
	private String descCategoria;	
	
	//private Parceiro parceiro;
	private Integer idParceiro;
	private String nomeParceiro;
	private String descParceiro;	
	
	@JsonFormat(pattern = "dd/MM/yyyy")	
	private LocalDate dataCriacao = LocalDate.now();

	// ****************************
	// ******* CONSTRUTORES *******
	// ****************************		
	public AnimalDTO() {
		super();
	}

	public AnimalDTO(Animal obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
		this.idStatusAnimal = obj.getStatus().getCodigo();
		this.descStatusAnimal = obj.getStatus().getDescricao();
		this.idCategoria = obj.getCategoria().getId();
		this.descCategoria = obj.getCategoria().getDescricao();
		this.idParceiro = obj.getParceiro().getId();
		this.nomeParceiro = obj.getParceiro().getNome();		
		this.descParceiro = obj.getParceiro().getDescricao();
		this.dataCriacao = obj.getDataCriacao();
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

	public Integer getIdStatusAnimal() {
		return idStatusAnimal;
	}

	public void setIdStatusAnimal(Integer idStatusAnimal) {
		this.idStatusAnimal = idStatusAnimal;
	}

	public String getDescStatusAnimal() {
		return descStatusAnimal;
	}

	public void setDescStatusAnimal(String descStatusAnimal) {
		this.descStatusAnimal = descStatusAnimal;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescCategoria() {
		return descCategoria;
	}

	public void setDescCategoria(String descCategoria) {
		this.descCategoria = descCategoria;
	}

	public Integer getIdParceiro() {
		return idParceiro;
	}

	public void setIdParceiro(Integer idParceiro) {
		this.idParceiro = idParceiro;
	}

	public String getNomeParceiro() {
		return nomeParceiro;
	}

	public void setNomeParceiro(String nomeParceiro) {
		this.nomeParceiro = nomeParceiro;
	}

	public String getDescParceiro() {
		return descParceiro;
	}

	public void setDescParceiro(String descParceiro) {
		this.descParceiro = descParceiro;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
}
