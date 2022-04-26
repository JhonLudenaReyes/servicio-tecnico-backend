package com.webservices.serviciotecnico.persistence.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservices.serviciotecnico.persistence.model.Permiso;

public interface PermisoDaoRepository extends JpaRepository<Permiso, Integer>{
	
	Optional<List<Permiso>> findAllByEstado(String state);

}
