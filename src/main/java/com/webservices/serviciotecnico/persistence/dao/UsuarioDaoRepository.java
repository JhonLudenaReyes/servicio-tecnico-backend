package com.webservices.serviciotecnico.persistence.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservices.serviciotecnico.persistence.model.Usuario;

public interface UsuarioDaoRepository extends JpaRepository<Usuario, Integer>{
	
	Optional<Usuario> findByUsuarioAndContrasenia(String usuario, String contrasenia);

}
