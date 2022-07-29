package com.webservices.serviciotecnico.domain.repository;

import java.util.List;

import com.webservices.serviciotecnico.persistence.model.Permit;

public interface PermitRepository {
	
	List<Permit> getPermits();

}
