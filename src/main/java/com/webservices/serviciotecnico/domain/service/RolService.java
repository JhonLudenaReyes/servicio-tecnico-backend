package com.webservices.serviciotecnico.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservices.serviciotecnico.domain.repository.RolRepository;
import com.webservices.serviciotecnico.persistence.model.Rol;
import com.webservices.serviciotecnico.persistence.model.entity.rol.RolSelect;

@Service
public class RolService {

	@Autowired
	private RolRepository rolRepository;
	
	public Optional<Rol> getRole(int idRole){
		return rolRepository.getRole(idRole);
	}
	
	public Optional<RolSelect> getRoleSelect(int roleId){
		return rolRepository.getRoleSelect(roleId);
	}
	
	public Optional<List<Rol>> getRolesActive(){
		return rolRepository.getAllRolesActive();
	}
	
	public Rol saveRol(Rol rol) {
		return rolRepository.saveRol(rol);
	}
	
	public Optional<List<RolSelect>> getRolesSelect(){
		return rolRepository.getRolesSelect();
	}
}
