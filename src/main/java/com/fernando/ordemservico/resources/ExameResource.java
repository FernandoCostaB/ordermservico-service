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

import com.fernando.ordemservico.domain.Exame;
import com.fernando.ordemservico.dto.ExameDTO;
import com.fernando.ordemservico.services.ExameService;

@RestController
@RequestMapping(value="/exames")
public class ExameResource {
	
	@Autowired
	private ExameService service;
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ExameDTO>> listar() {
		List<Exame> lista = service.findAll();
		List<ExameDTO> listDto = lista.stream().map(obj->new ExameDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
		
		Exame obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
