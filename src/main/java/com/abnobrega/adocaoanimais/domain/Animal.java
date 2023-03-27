package com.abnobrega.adocaoanimais.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.abnobrega.adocaoanimais.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Animal implements Serializable {
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
	
	private Status status; 
	
	@ManyToOne
    @JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "parceiro_id")
	private Parceiro parceiro;
		
	@JsonFormat(pattern = "dd/MM/yyy")
	private LocalDate dataCriacao = LocalDate.now();

	//****************************
	//******* CONSTRUTORES *******
	//****************************		
	public Animal() {
		super();
	}

	public Animal(Integer id, String nome, String descricao, Status status, Categoria categoria, Parceiro parceiro) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.status = status;
		this.categoria = categoria;
		this.parceiro = parceiro;
	}

	public Animal(Integer id, String nome, String descricao, Status status, Categoria categoria, Parceiro parceiro,
			LocalDate dataCriacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.status = status;
		this.categoria = categoria;
		this.parceiro = parceiro;
		this.dataCriacao = dataCriacao;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Parceiro getParceiro() {
		return parceiro;
	}

	public void setParceiro(Parceiro parceiro) {
		this.parceiro = parceiro;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(id, other.id);
	}

}
