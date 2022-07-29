package com.webservices.serviciotecnico.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webservices.serviciotecnico.domain.repository.RoleRepository;
import com.webservices.serviciotecnico.persistence.dao.RoleDaoRepository;
import com.webservices.serviciotecnico.persistence.model.Role;

@Repository
public class RoleRepositoryImpl implements RoleRepository{
	
	@Autowired
	private RoleDaoRepository roleDaoRepository;

	@Override
	public List<Role> getRoles() {
		// TODO Auto-generated method stub
		return roleDaoRepository.findAll();
	}

}
