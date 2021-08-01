package com.fernando.ordemservico.services;

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
	
	public Medico buscar(Integer id) {
		Optional<Medico> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado!"));
	}
}
