package com.webservices.serviciotecnico.domain.repository;

import java.util.List;
import java.util.Optional;

import com.webservices.serviciotecnico.persistence.model.entity.Role;

public interface RoleRepository {
	
	List<Role> getRoles();
	Optional<List<Role>> getActiveRoles();

}
