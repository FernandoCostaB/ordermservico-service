package com.fernando.ordemservico.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fernando.ordemservico.domain.PostoColeta;
import com.fernando.ordemservico.repositories.PostoColetaRepository;
import com.fernando.ordemservico.services.exceptions.ObjectNotFoundException;

@Service
public class PostoColetaService {
	
	private PostoColetaRepository repo;
	
	public PostoColeta buscar(Integer id) {
		Optional<PostoColeta> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado!"));
	}
}
