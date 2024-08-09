package com.webservices.serviciotecnico.persistence.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservices.serviciotecnico.persistence.model.Permit;

public interface PermitDaoRepository extends JpaRepository<Permit, Integer>{
	
	Optional<List<Permit>> findAllByEstado(String estado);

}
