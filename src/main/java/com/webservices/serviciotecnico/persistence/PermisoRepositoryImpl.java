package com.webservices.serviciotecnico.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webservices.serviciotecnico.domain.repository.PermisoRepository;
import com.webservices.serviciotecnico.persistence.dao.PermisoDaoRepository;
import com.webservices.serviciotecnico.persistence.model.Permiso;

@Repository
public class PermisoRepositoryImpl implements PermisoRepository{
	
	@Autowired
	private PermisoDaoRepository permisoDaoRepository;

	@Override
	public Permiso save(Permiso permiso) {
		// TODO Auto-generated method stub 
		return permisoDaoRepository.save(permiso);
	}

	@Override
	public Optional<List<Permiso>> findPermits() {
		// TODO Auto-generated method stub
		Optional<List<Permiso>> permisos = permisoDaoRepository.findAllByEstado("A");
		return permisos;
	}

	@Override
	public Optional<Permiso> getPermit(int permitId) {
		// TODO Auto-generated method stub
		return permisoDaoRepository.findById(permitId);
	}
	
	

}
