package com.fernando.ordemservico.dto;

import java.io.Serializable;
import java.util.Date;

import com.fernando.ordemservico.domain.Paciente;

public class PacienteDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Date dataNascimento;
	private String sexo;
	private String endereco;
	
	public PacienteDTO() {
		
	}
	
	public PacienteDTO(Paciente obj) {
		id = obj.getId();
		nome = obj.getNome();
		dataNascimento = obj.getDataNascimento();
		sexo = obj.getSexo();
		endereco = obj.getEndereco();
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
