package com.fernando.ordemservico.dto;

import java.io.Serializable;
import java.util.Date;

import com.fernando.ordemservico.domain.Medico;
import com.fernando.ordemservico.domain.OrdemServico;
import com.fernando.ordemservico.domain.OrdemServicoExame;
import com.fernando.ordemservico.domain.Paciente;
import com.fernando.ordemservico.domain.PostoColeta;

public class OrdemServicoDTO  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date data;
	private String convenio;
	private Paciente paciente;
	private PostoColeta postoColeta;
	private Medico medico;
	private OrdemServicoExame ordemServicoExame;
	
	public OrdemServicoDTO() {}

	public OrdemServicoDTO(OrdemServico obj) {
		id=obj.getId();
		data=obj.getData();
		convenio=obj.getConvenio();
		paciente = obj.getPaciente();
		postoColeta = obj.getPostoColeta();
		medico = obj.getMedico();
		ordemServicoExame = obj.getOrdemServicoExame();
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
