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

import com.fernando.ordemservico.domain.Paciente;
import com.fernando.ordemservico.dto.PacienteDTO;
import com.fernando.ordemservico.services.PacienteService;

@RestController
@RequestMapping(value="/pacientes")
public class PacienteResource {
	@Autowired
	private PacienteService service;

	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PacienteDTO>> listar() {
		List<Paciente> lista = service.findAll();
		List<PacienteDTO> listDto = lista.stream().map(obj->new PacienteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
		
		Paciente obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
