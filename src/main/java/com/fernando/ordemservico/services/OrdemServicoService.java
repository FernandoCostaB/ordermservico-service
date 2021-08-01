package com.fernando.ordemservico.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fernando.ordemservico.domain.OrdemServico;
import com.fernando.ordemservico.repositories.OrdemServicoRepository;
import com.fernando.ordemservico.services.exceptions.ObjectNotFoundException;

@Service
public class OrdemServicoService {

	private OrdemServicoRepository repo;
	
	public OrdemServico buscar(Integer id) {
		Optional<OrdemServico> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado!"));
	}
}
