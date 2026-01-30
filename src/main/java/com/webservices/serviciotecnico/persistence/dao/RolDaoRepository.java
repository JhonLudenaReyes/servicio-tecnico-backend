package com.webservices.serviciotecnico.persistence.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.webservices.serviciotecnico.persistence.model.Rol;

public interface RolDaoRepository extends JpaRepository<Rol, Integer> {

	// nativeQuery
	// @Query(value = "select id_rol, rol, estado from roles where estado = 'A'",
	// nativeQuery = true)
	// Optional<List<Rol>> getRoles();

	Optional<List<Rol>> findByEstado(String estado);

}
