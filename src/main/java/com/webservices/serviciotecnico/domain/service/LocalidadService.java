package com.webservices.serviciotecnico.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservices.serviciotecnico.domain.repository.LocalidadRepository;
import com.webservices.serviciotecnico.persistence.model.Localidad;

@Service
public class LocalidadService {

	@Autowired
	private LocalidadRepository localidadRepository;
	
	public Optional<List<Localidad>> getLocalidades(){
		return localidadRepository.getLocalidades("A");
	}
}
