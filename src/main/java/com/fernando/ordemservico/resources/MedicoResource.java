package com.fernando.ordemservico.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fernando.ordemservico.domain.Medico;
import com.fernando.ordemservico.services.MedicoService;

@RestController
@RequestMapping(value="/medicos")
public class MedicoResource {
	
	@Autowired
	private MedicoService service;

	@RequestMapping(method=RequestMethod.GET)
	public List<Medico> listar() {
		
		Medico med1 = new Medico(1, "Fernando", "Pediatra");
		Medico med2 = new Medico(2, "Maria", "Pediatra");
		
		
		List<Medico> listaMedico = new ArrayList<Medico>();
		
		listaMedico.add(med1);
		listaMedico.add(med2);
		
		return listaMedico;
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
		
		Medico obj = service.buscar(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
