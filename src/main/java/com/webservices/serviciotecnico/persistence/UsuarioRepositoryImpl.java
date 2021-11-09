package com.webservices.serviciotecnico.persistence;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webservices.serviciotecnico.domain.repository.UsuarioRepository;
import com.webservices.serviciotecnico.persistence.dao.UsuarioDaoRepository;
import com.webservices.serviciotecnico.persistence.model.Usuario;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository{
	
	@Autowired
	private UsuarioDaoRepository usuarioDaoRepository;

	@Override
	public Optional<Usuario> getUsuarioLogin(String usuario, String contrasenia) {
		// TODO Auto-generated method stub
		return usuarioDaoRepository.findByUsuarioAndContrasenia(usuario, contrasenia);
	}

}
