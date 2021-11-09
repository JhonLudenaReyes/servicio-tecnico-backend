package com.webservices.serviciotecnico.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservices.serviciotecnico.domain.repository.PersonaRepository;
import com.webservices.serviciotecnico.persistence.model.Persona;

@Service
public class PersonaService {

	@Autowired
	private PersonaRepository personaRepository;

	public Optional<Persona> getPersona(int idPersona) {
		return personaRepository.getPersona(idPersona);
	}

}
