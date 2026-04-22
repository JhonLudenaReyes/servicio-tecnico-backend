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
	
	private final PermisoDaoRepository permisoDaoRepository;

	public PermisoRepositoryImpl(PermisoDaoRepository permisoDaoRepository) {
		this.permisoDaoRepository = permisoDaoRepository;
	}

	@Override
	public Permiso save(Permiso permiso) {
		return permisoDaoRepository.save(permiso);
	}

	@Override
	public Optional<List<Permiso>> findPermisos() {
		return permisoDaoRepository.findAllByEstado("A");
	}

	@Override
	public Optional<Permiso> getPermiso(int idPermiso) {
		return permisoDaoRepository.findById(idPermiso);
	}

}
