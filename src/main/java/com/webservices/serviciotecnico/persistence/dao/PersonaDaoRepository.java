package com.webservices.serviciotecnico.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservices.serviciotecnico.persistence.model.Persona;

public interface PersonaDaoRepository extends JpaRepository<Persona, Integer> {

}
