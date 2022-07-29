package com.webservices.serviciotecnico.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservices.serviciotecnico.persistence.model.Role;

public interface RoleDaoRepository extends JpaRepository<Role, Integer>{
	
	List<Role> findAll();

}
