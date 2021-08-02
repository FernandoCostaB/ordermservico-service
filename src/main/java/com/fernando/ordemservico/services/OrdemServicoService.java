package com.fernando.ordemservico.services;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.ordemservico.domain.OrdemServico;
import com.fernando.ordemservico.domain.OrdemServicoExame;
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
		OrdemServicoExame aux = obj.getOrdemServicoExame();
		obj.setData(Calendar.getInstance().getTime());
		obj.setId(null);
		OrdemServico ordem = ordemServicoRepository.save(obj);
		aux.setOrdemServico(ordem);
		ordemServicoExameRepository.save(aux);
		
		return ordem;
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
