package com.fernando.ordemservico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.ordemservico.domain.OrdemServico;
import com.fernando.ordemservico.repositories.OrdemServicoRepository;
import com.fernando.ordemservico.services.exceptions.ObjectNotFoundException;

@Service
public class OrdemServicoService {

	@Autowired
	private OrdemServicoRepository repo;
	
	public OrdemServico findById(Integer id) {
		Optional<OrdemServico> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado!"));
	}
	
	public OrdemServico insert(OrdemServico obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public OrdemServico update(OrdemServico obj) {
		findById(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public List<OrdemServico> findAll(){
		return repo.findAll();
	}
}
