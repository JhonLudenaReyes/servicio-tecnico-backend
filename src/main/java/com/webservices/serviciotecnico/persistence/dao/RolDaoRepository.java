package com.webservices.serviciotecnico.persistence.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservices.serviciotecnico.persistence.model.Rol;

public interface RolDaoRepository extends JpaRepository<Rol, Integer>{

	Optional<List<Rol>> findByEstado(String estado);
}
