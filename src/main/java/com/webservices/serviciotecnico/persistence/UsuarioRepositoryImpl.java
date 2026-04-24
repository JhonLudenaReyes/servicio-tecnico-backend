package com.webservices.serviciotecnico.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.webservices.serviciotecnico.domain.repository.UsuarioRepository;
import com.webservices.serviciotecnico.persistence.dao.UsuarioDaoRepository;
import com.webservices.serviciotecnico.persistence.model.Usuario;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository{
	
	private final UsuarioDaoRepository usuarioDaoRepository;

	public UsuarioRepositoryImpl(UsuarioDaoRepository usuarioDaoRepository) {
		this.usuarioDaoRepository = usuarioDaoRepository;
	}

	@Override
	public Optional<Usuario> getUsuarioLogin(String usuario, String contrasenia) {
		return usuarioDaoRepository.findByUsuarioAndContrasenia(usuario, contrasenia);
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioDaoRepository.save(usuario);
	}

	@Override
	public Optional<Usuario> getByUsuario(String usuario) {
		return usuarioDaoRepository.findByUsuario(usuario);
	}

}
