package com.abnobrega.adocaoanimais.domain.enums;

public enum Status {
	
	// Valores dos Status
	DISPONIVEL(0, "DISPONIVEL"), ADOTADO(1, "ADOTADO");
	
	//*************************
	//******* ATRIBUTOS *******
	//*************************	
	private Integer codigo;
	private String descricao;

	//**************************
	//******* CONSTRUTOR *******
	//**************************	
	private Status(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	//*************************
	//*******  MÉTODOS  *******
	//*************************	
	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Status toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for(Status x: Status.values()) {
			if(cod.equals(x.getCodigo())) {
				return x; // Retorna o Status existente.
			}
			
		}
		
		// Se não retornou, então lançar uma exceção
		throw new IllegalArgumentException("Status inválido");
		
	}
	
}
