package com.webservices.serviciotecnico.domain.repository;

import java.util.List;
import java.util.Optional;

import com.webservices.serviciotecnico.persistence.model.Permiso;

public interface PermisoRepository {
	
	Permiso save(Permiso permiso);
	Optional<Permiso> getPermit(int permitId);
	Optional<List<Permiso>> findPermits();

}
