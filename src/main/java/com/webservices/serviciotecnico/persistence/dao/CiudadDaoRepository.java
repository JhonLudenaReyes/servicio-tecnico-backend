package com.webservices.serviciotecnico.persistence.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservices.serviciotecnico.persistence.model.Ciudad;

public interface CiudadDaoRepository extends JpaRepository<Ciudad, Integer>{

	Optional<List<Ciudad>> findByEstado(String estado);
}
