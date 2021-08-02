package com.fernando.ordemservico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.ordemservico.domain.Medico;
import com.fernando.ordemservico.domain.OrdemServico;
import com.fernando.ordemservico.domain.OrdemServicoExame;
import com.fernando.ordemservico.domain.Paciente;
import com.fernando.ordemservico.domain.PostoColeta;
import com.fernando.ordemservico.repositories.MedicoRepository;
import com.fernando.ordemservico.repositories.OrdemServicoExameRepository;
import com.fernando.ordemservico.repositories.OrdemServicoRepository;
import com.fernando.ordemservico.repositories.PacienteRepository;
import com.fernando.ordemservico.repositories.PostoColetaRepository;
import com.fernando.ordemservico.services.exceptions.ObjectNotFoundException;

@Service
public class OrdemServicoService {

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private PostoColetaRepository postoColetaRepository;
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private OrdemServicoExameRepository ordemServicoExameRepository;
	
	
	
	public OrdemServico findById(Integer id) {
		Optional<OrdemServico> obj = ordemServicoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}
	
	public OrdemServico insert(OrdemServico obj) {
		obj.setId(null);
		return ordemServicoRepository.save(obj);
	}
	
	public OrdemServico update(OrdemServico obj) {
		findById(obj.getId());
		return ordemServicoRepository.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		ordemServicoRepository.deleteById(id);
	}
	
	public List<OrdemServico> findAll(){
		return ordemServicoRepository.findAll();
	}
}
