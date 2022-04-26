package com.webservices.serviciotecnico.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservices.serviciotecnico.domain.repository.PermisoRepository;
import com.webservices.serviciotecnico.persistence.model.Permiso;

@Service
public class PermisoService {
	
	@Autowired
	private PermisoRepository permisoRepository;
	
	public Permiso save(Permiso permiso) {
		return permisoRepository.save(permiso);
	}
	
	public Optional<List<Permiso>> findPermits(){
		return permisoRepository.findPermits();
	}

}
