package com.webservices.serviciotecnico.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{idPersona}")
	public ResponseEntity<Persona> getPersona(@PathVariable("idPersona") int idPersona) {
		return personaService.getPersona(idPersona).map(persona -> new ResponseEntity<>(persona, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/people-active")
	public ResponseEntity<List<Persona>> getAllPeople() {
		return personaService.getAllPeople().map(personas -> new ResponseEntity<>(personas, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/save")
	public ResponseEntity<Persona> save(@RequestBody Persona persona) {
		return new ResponseEntity<>(personaService.save(persona), HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update-person")
	public ResponseEntity<Persona> updatePerson(@RequestBody Persona persona){
		Optional<Persona> optionalPerson = personaService.getPersona(persona.getIdPersona());
		if(optionalPerson.isPresent()) {
			return new ResponseEntity<>(personaService.save(persona), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/delete-person-log/{personId}")
	public ResponseEntity<Persona> deletePerson(@PathVariable("personId") int personId){
		Optional<Persona> optionalPerson = personaService.getPersona(personId);
		if(optionalPerson.isPresent()) {
			Persona updatePerson = optionalPerson.get();
			updatePerson.setEstado("I");
			return new ResponseEntity<>(personaService.save(updatePerson), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
