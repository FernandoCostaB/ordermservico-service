package com.fernando.ordemservico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.ordemservico.domain.Exame;
import com.fernando.ordemservico.repositories.ExameRepository;
import com.fernando.ordemservico.services.exceptions.ObjectNotFoundException;

@Service
public class ExameService {
	
	@Autowired
	private ExameRepository repo;
	
	public Exame findById(Integer id) {
		Optional<Exame> obj= repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado!"));
	}
	
	public Exame insert(Exame obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Exame update(Exame obj) {
		findById(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public List<Exame> findAll(){
		return repo.findAll();
	}
}
