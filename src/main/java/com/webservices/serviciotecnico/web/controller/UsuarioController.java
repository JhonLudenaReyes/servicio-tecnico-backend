package com.webservices.serviciotecnico.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservices.serviciotecnico.domain.service.UsuarioService;
import com.webservices.serviciotecnico.persistence.model.Usuario;

import org.springframework.security.core.Authentication;

import com.webservices.serviciotecnico.domain.dto.UsuarioDTO;
import com.webservices.serviciotecnico.domain.mapper.UsuarioMapper;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	private final UsuarioMapper usuarioMapper;

	public UsuarioController(UsuarioService usuarioService, UsuarioMapper usuarioMapper) {
		this.usuarioService = usuarioService;
		this.usuarioMapper = usuarioMapper;
	}
	
	@PostMapping("/save")
	public ResponseEntity<UsuarioDTO> save(@RequestBody Usuario usuario) {
		Usuario savedUser = usuarioService.save(usuario);
		return new ResponseEntity<>(usuarioMapper.toDTO(savedUser), HttpStatus.CREATED);
	}

	@GetMapping("/me")
	public ResponseEntity<UsuarioDTO> getAuthenticatedUser(Authentication authentication) {
		return usuarioService.getByUsuario(authentication.getName())
				.map(user -> new ResponseEntity<>(usuarioMapper.toDTO(user), HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
