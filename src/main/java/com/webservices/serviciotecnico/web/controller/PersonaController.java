package com.webservices.serviciotecnico.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservices.serviciotecnico.domain.service.PersonaService;
import com.webservices.serviciotecnico.persistence.model.Persona;

@RestController
@RequestMapping("/personas")
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	@GetMapping("/{idPersona}")
	public ResponseEntity<Persona> getPersona(@PathVariable("idPersona") int idPersona){
		return personaService.getPersona(idPersona)
				.map(persona -> new ResponseEntity<>(persona, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/save")
	public ResponseEntity<Persona> save(@RequestBody Persona persona){
		return new ResponseEntity<>(personaService.save(persona), HttpStatus.CREATED);
	}

}
