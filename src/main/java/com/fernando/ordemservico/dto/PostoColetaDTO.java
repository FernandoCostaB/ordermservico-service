package com.fernando.ordemservico.dto;

import java.io.Serializable;

import com.fernando.ordemservico.domain.PostoColeta;

public class PostoColetaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String descricao;
	private String endereco;
	
	public PostoColetaDTO() {}
	
	public PostoColetaDTO(PostoColeta obj) {
		id = obj.getId();
		descricao = obj.getDescricao();
		endereco = obj.getEndereco();
				
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	

	

}
