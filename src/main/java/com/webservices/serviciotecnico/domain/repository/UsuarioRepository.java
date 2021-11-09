package com.webservices.serviciotecnico.domain.repository;

import java.util.Optional;

import com.webservices.serviciotecnico.persistence.model.Usuario;

public interface UsuarioRepository {
	
	Optional<Usuario> getUsuarioLogin(String usuario, String contrasenia);

}
