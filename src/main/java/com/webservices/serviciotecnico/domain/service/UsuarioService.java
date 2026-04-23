package com.webservices.serviciotecnico.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservices.serviciotecnico.domain.repository.UsuarioRepository;
import com.webservices.serviciotecnico.persistence.model.Usuario;

import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder passwordEncoder;

	public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
		this.usuarioRepository = usuarioRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public Usuario save(Usuario usuario) {
		usuario.setContrasenia(passwordEncoder.encode(usuario.getContrasenia()));
		return usuarioRepository.save(usuario);
	}

	public Optional<Usuario> getByUsuario(String usuario) {
		return usuarioRepository.getByUsuario(usuario);
	}
	
	public Optional<Usuario> getUsuarioLogin(String usuario, String contrasenia){
		return usuarioRepository.getUsuarioLogin(usuario, contrasenia);
	}

}
