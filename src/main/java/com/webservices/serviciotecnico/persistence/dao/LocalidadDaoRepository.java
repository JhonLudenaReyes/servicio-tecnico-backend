package com.webservices.serviciotecnico.persistence.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservices.serviciotecnico.persistence.model.Localidad;

public interface LocalidadDaoRepository extends JpaRepository<Localidad, Integer>{

	Optional<List<Localidad>> findByEstado(String estado);
}
