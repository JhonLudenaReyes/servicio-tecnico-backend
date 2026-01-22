package com.webservices.serviciotecnico.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservices.serviciotecnico.domain.repository.CiudadRepository;
import com.webservices.serviciotecnico.persistence.model.Ciudad;

@Service
public class CiudadService {

	@Autowired
	private CiudadRepository ciudadRepository;
	
	public Optional<List<Ciudad>> getCiudades(){
		return ciudadRepository.getCiudades("A");
	}
}
