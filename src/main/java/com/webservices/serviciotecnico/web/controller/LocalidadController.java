package com.webservices.serviciotecnico.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservices.serviciotecnico.domain.service.LocalidadService;
import com.webservices.serviciotecnico.persistence.model.Localidad;

@RestController
@RequestMapping("/localidades")
public class LocalidadController {
	
	@Autowired
	private LocalidadService localidadService;
	
	@GetMapping("/lista")
	public ResponseEntity<List<Localidad>> getLocalidades(){
		return localidadService.getLocalidades()
				.map(localidades -> new ResponseEntity<>(localidades, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
