package com.webservices.serviciotecnico.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webservices.serviciotecnico.domain.repository.PersonaRepository;
import com.webservices.serviciotecnico.persistence.dao.PersonaDaoRepository;
import com.webservices.serviciotecnico.persistence.model.Persona;

@Repository
public class PersonaRepositoryImpl implements PersonaRepository{
	
	@Autowired
	private PersonaDaoRepository personaDaoRepository;

	@Override
	public Optional<Persona> getPersona(int idPersona) {
		// TODO Auto-generated method stub
		return personaDaoRepository.findById(idPersona);
	}

	@Override
	public Persona save(Persona persona) {
		// TODO Auto-generated method stub
		return personaDaoRepository.save(persona);
	}

	@Override
	public Optional<List<Persona>> getPeopleActive() {
		// TODO Auto-generated method stub
		Optional<List<Persona>> personas = personaDaoRepository.findAllByEstado("A");
		return personas;
	}
	

}
