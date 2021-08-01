package com.fernando.ordemservico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fernando.ordemservico.domain.Medico;
import com.fernando.ordemservico.repositories.MedicoRepository;
import com.fernando.ordemservico.services.exceptions.ObjectNotFoundException;



@Service
public class MedicoService {
	
	@Autowired
	private MedicoRepository repo;
	
	public Medico findById(Integer id) {
		Optional<Medico> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado!"));
	}
	
	public Medico insert(Medico obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Medico update(Medico obj) {
		findById(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public List<Medico> findAll(){
		return repo.findAll();
	}
}
