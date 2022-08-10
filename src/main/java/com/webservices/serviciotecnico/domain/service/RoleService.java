package com.webservices.serviciotecnico.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservices.serviciotecnico.domain.repository.RoleRepository;
import com.webservices.serviciotecnico.persistence.model.Role;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> getRoles(){
		return roleRepository.getRoles();
	}
	
	public Optional<List<Role>> getActiveRoles(){
		return roleRepository.getActiveRoles();
	}
}
