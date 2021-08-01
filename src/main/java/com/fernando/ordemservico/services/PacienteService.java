package com.fernando.ordemservico.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fernando.ordemservico.domain.Paciente;
import com.fernando.ordemservico.repositories.PacienteRepository;
import com.fernando.ordemservico.services.exceptions.ObjectNotFoundException;

@Service
public class PacienteService {

	private PacienteRepository repo;
	
	public Paciente buscar(Integer id) {
		Optional<Paciente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado!"));
	}
}
