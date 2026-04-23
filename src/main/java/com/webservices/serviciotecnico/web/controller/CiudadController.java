package com.webservices.serviciotecnico.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservices.serviciotecnico.domain.service.CiudadService;
import com.webservices.serviciotecnico.persistence.model.Ciudad;

@RestController
@RequestMapping("/ciudades")
public class CiudadController {

	private final CiudadService ciudadService;

	public CiudadController(CiudadService ciudadService) {
		this.ciudadService = ciudadService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Ciudad>> getAll(){
		return ciudadService.getCiudades().map(ciudades -> new ResponseEntity<>(ciudades, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}

