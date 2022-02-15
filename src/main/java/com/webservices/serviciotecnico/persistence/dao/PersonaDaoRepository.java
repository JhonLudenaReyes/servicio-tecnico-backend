package com.webservices.serviciotecnico.persistence.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservices.serviciotecnico.persistence.model.Persona;

public interface PersonaDaoRepository extends JpaRepository<Persona, Integer> {
	
	Optional<List<Persona>> findAllByEstado(String estado);

}
