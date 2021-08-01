package com.fernando.ordemservico.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fernando.ordemservico.domain.OrdemServicoExame;
import com.fernando.ordemservico.repositories.OrdemServicoExameRepository;
import com.fernando.ordemservico.services.exceptions.ObjectNotFoundException;

@Service
public class OrdemServicoExameService {
	
	private OrdemServicoExameRepository repo;
	
	public OrdemServicoExame buscar(Integer id) {
		Optional<OrdemServicoExame> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado!"));
	}
}
