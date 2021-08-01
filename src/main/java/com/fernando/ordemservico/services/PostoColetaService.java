package com.fernando.ordemservico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.ordemservico.domain.PostoColeta;

import com.fernando.ordemservico.repositories.PostoColetaRepository;
import com.fernando.ordemservico.services.exceptions.ObjectNotFoundException;

@Service
public class PostoColetaService {
	
	@Autowired
	private PostoColetaRepository repo;
	
	public PostoColeta findById(Integer id) {
		Optional<PostoColeta> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado!"));
	}
	
	public PostoColeta insert(PostoColeta obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public PostoColeta update(PostoColeta obj) {
		findById(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public List<PostoColeta> findAll(){
		return repo.findAll();
	}
}
