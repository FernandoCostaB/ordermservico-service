package com.fernando.ordemservico.dto;

import java.io.Serializable;

import com.fernando.ordemservico.domain.Exame;

public class ExameDTO  implements Serializable{


	private static final long serialVersionUID = 1L;

	private Integer id;
	private String descricao;
	private Double preco;
	
	public ExameDTO() {
		
	}
	
	public ExameDTO(Exame obj) {
		id = obj.getId();	
		descricao = obj.getDescricao();
		preco = obj.getPreco();
	}

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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
}
