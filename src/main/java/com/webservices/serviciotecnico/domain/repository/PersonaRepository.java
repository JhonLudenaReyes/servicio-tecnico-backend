package com.webservices.serviciotecnico.domain.repository;

import java.util.List;
import java.util.Optional;

import com.webservices.serviciotecnico.persistence.model.Persona;

public interface PersonaRepository {

	Optional<Persona> getPersona(int idPersona);
	Optional<List<Persona>> getPeopleActive();
	Persona save(Persona persona);

}
