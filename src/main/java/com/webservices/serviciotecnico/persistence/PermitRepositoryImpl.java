package com.webservices.serviciotecnico.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webservices.serviciotecnico.domain.repository.PermitRepository;
import com.webservices.serviciotecnico.persistence.dao.PermitDaoRepository;
import com.webservices.serviciotecnico.persistence.model.Permit;

@Repository
public class PermitRepositoryImpl implements PermitRepository{

	@Autowired
	private PermitDaoRepository permitDaoRepository;
	
	@Override
	public List<Permit> getPermits() {
		// TODO Auto-generated method stub
		return permitDaoRepository.findAll();
	}
	
	

}
