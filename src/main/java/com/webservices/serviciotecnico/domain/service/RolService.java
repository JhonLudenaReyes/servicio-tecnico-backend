package com.webservices.serviciotecnico.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservices.serviciotecnico.domain.repository.RolRepository;
import com.webservices.serviciotecnico.persistence.model.Rol;

@Service
public class RolService {

	@Autowired
	private RolRepository rolRepository;
	
	public Optional<List<Rol>> getRolesActive(){
		return rolRepository.getAllRolesActive();
	}
}
