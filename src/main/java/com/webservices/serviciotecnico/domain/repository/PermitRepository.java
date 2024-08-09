package com.webservices.serviciotecnico.domain.repository;

import java.util.List;
import java.util.Optional;

import com.webservices.serviciotecnico.persistence.model.Permit;

public interface PermitRepository {
	
	Optional<List<Permit>> getPermits();
	
	Permit save(Permit permit);

}
