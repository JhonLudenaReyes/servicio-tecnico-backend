package com.webservices.serviciotecnico.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservices.serviciotecnico.domain.service.PermisoService;
import com.webservices.serviciotecnico.persistence.model.Permiso;

@RestController
@RequestMapping("/permisos")
public class PermisoController {

	@Autowired
	private PermisoService permisoService;

	@PostMapping("/save_permits")
	public ResponseEntity<Permiso> save(@RequestBody Permiso permiso) {
		return new ResponseEntity<>(permisoService.save(permiso), HttpStatus.CREATED);
	}

	@GetMapping("/all-permits")
	public ResponseEntity<List<Permiso>> findPermits() {
		return permisoService.findPermits().map(permit -> new ResponseEntity<>(permit, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
