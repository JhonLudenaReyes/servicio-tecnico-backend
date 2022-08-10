package com.webservices.serviciotecnico.persistence.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.webservices.serviciotecnico.persistence.model.Role;

public interface RoleDaoRepository extends JpaRepository<Role, Integer>{
	
	List<Role> findAll();
	
	@Query(value = "select id_rol, rol from roles where estado = 'A'", nativeQuery = true)
	Optional<List<Role>> getRoles();

}
