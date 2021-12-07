package com.webservices.serviciotecnico.domain.repository;

import java.util.Optional;

import com.webservices.serviciotecnico.persistence.model.Persona;

public interface PersonaRepository {

	Optional<Persona> getPersona(int idPersona);
	Persona save(Persona persona);

}
