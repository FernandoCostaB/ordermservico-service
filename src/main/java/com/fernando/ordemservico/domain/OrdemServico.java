package com.fernando.ordemservico.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class OrdemServico implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date data;
	private String convenio;
	
	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name = "posto_coleta_id")
	private PostoColeta postoColeta;
	

	@ManyToOne
	@JoinColumn(name = "medico_id")
	private Medico medico;
	
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "ordemServico" )
	private OrdemServicoExame ordemServicoExame;
	
	
	public OrdemServico() {}


	public OrdemServico(Integer id, Date data, String convenio, Paciente paciente, PostoColeta postoColeta,
			Medico medico) {
		super();
		this.id = id;
		this.data = data;
		this.convenio = convenio;
		this.paciente = paciente;
		this.postoColeta = postoColeta;
		this.medico = medico;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public String getConvenio() {
		return convenio;
	}


	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}


	public Paciente getPaciente() {
		return paciente;
	}


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}


	public PostoColeta getPostoColeta() {
		return postoColeta;
	}


	public void setPostoColeta(PostoColeta postoColeta) {
		this.postoColeta = postoColeta;
	}


	public Medico getMedico() {
		return medico;
	}


	public void setMedico(Medico medico) {
		this.medico = medico;
	}


	public OrdemServicoExame getOrdemServicoExame() {
		return ordemServicoExame;
	}


	public void setOrdemServicoExame(OrdemServicoExame ordemServicoExame) {
		this.ordemServicoExame = ordemServicoExame;
	}
	
	
	
	
}
