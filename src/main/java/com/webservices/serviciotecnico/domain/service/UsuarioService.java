package com.webservices.serviciotecnico.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservices.serviciotecnico.domain.repository.UsuarioRepository;
import com.webservices.serviciotecnico.persistence.model.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Optional<Usuario> getUsuarioLogin(String usuario, String contrasenia){
		return usuarioRepository.getUsuarioLogin(usuario, contrasenia);
	}

}
