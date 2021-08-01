package com.fernando.ordemservico.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/medicos")
public class MedicoResource {

	@RequestMapping(method=RequestMethod.GET)
	public String listar() {
		return "rest ta funcionando!";
	}
}
