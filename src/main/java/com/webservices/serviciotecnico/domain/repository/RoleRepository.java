package com.webservices.serviciotecnico.domain.repository;

import java.util.List;

import com.webservices.serviciotecnico.persistence.model.Role;

public interface RoleRepository {
	
	List<Role> getRoles();

}
