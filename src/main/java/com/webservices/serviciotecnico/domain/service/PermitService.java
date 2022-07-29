package com.webservices.serviciotecnico.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservices.serviciotecnico.domain.repository.PermitRepository;
import com.webservices.serviciotecnico.persistence.model.Permit;

@Service
public class PermitService {
	
	@Autowired
	PermitRepository permitRepository;
	
	public List<Permit> getPermits(){
		return permitRepository.getPermits();
	}

}
