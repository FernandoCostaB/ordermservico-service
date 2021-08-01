package com.fernando.ordemservico.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fernando.ordemservico.domain.PostoColeta;
import com.fernando.ordemservico.dto.PostoColetaDTO;
import com.fernando.ordemservico.services.PostoColetaService;

@RestController
@RequestMapping(value="/postos-coleta")
public class PostoColetaResource {
	
	@Autowired
	private PostoColetaService service;

	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PostoColetaDTO>> listar() {
		List<PostoColeta> lista = service.findAll();
		List<PostoColetaDTO> listDto = lista.stream().map(obj->new PostoColetaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
		
		PostoColeta obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
