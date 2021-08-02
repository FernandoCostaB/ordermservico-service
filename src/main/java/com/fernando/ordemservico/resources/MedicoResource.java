package com.fernando.ordemservico.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fernando.ordemservico.domain.Medico;
import com.fernando.ordemservico.dto.MedicoDTO;
import com.fernando.ordemservico.services.MedicoService;

@RestController
@RequestMapping(value="/medicos")
public class MedicoResource {
	
	@Autowired
	private MedicoService service;

	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<MedicoDTO>> listar() {
		List<Medico> lista = service.findAll();
		List<MedicoDTO> listDto = lista.stream().map(obj->new MedicoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
		
		Medico obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Medico obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
