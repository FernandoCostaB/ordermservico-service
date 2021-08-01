package com.fernando.ordemservico.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class OrdemServicoExame implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double preco;
	
	@OneToOne
	@JsonBackReference
	@JoinColumn(name = "ordem_servico_id")
	private OrdemServico ordemServico;
	
	@ManyToMany
	@JsonManagedReference
	@JoinTable(
	name="OS_EXAMES",
	joinColumns = @JoinColumn(name= "ordem_servico_exame_id"), 
	inverseJoinColumns = @JoinColumn(name="exame_id")
	)
	private List<Exame> exames = new ArrayList<>();
 	
	public OrdemServicoExame() {}

	public OrdemServicoExame(Integer id, Double preco, OrdemServico ordemServico) {
		super();
		this.id = id;
		this.preco = preco;
		this.ordemServico = ordemServico;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
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
		OrdemServicoExame other = (OrdemServicoExame) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
