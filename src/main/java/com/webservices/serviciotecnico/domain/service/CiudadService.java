package com.webservices.serviciotecnico.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.webservices.serviciotecnico.domain.repository.CiudadRepository;
import com.webservices.serviciotecnico.persistence.model.Ciudad;

@Service
public class CiudadService {

	private final CiudadRepository ciudadRepository;

	public CiudadService(CiudadRepository ciudadRepository) {
		this.ciudadRepository = ciudadRepository;
	}
	
	public Optional<List<Ciudad>> getCiudades(){
		return ciudadRepository.getCiudades("A");
	}
}
