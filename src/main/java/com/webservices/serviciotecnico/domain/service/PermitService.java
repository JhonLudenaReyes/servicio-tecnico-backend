package com.webservices.serviciotecnico.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservices.serviciotecnico.domain.repository.PermitRepository;
import com.webservices.serviciotecnico.persistence.model.Permit;

@Service
public class PermitService {
	
	@Autowired
	PermitRepository permitRepository;
	
	public Optional<List<Permit>> getPermits(){
		return permitRepository.getPermits();
	}
	
	public Permit save(Permit permit) {
		return permitRepository.save(permit);
	}

}
