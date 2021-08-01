package com.fernando.ordemservico.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fernando.ordemservico.domain.Exame;
import com.fernando.ordemservico.repositories.ExameRepository;
import com.fernando.ordemservico.services.exceptions.ObjectNotFoundException;

@Service
public class ExameService {
	
	private ExameRepository repo;
	
	public Exame buscar(Integer id) {
		Optional<Exame> obj= repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado!"));
	}
}
