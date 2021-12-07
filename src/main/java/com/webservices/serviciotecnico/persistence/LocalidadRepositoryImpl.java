package com.webservices.serviciotecnico.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webservices.serviciotecnico.domain.repository.LocalidadRepository;
import com.webservices.serviciotecnico.persistence.dao.LocalidadDaoRepository;
import com.webservices.serviciotecnico.persistence.model.Localidad;

@Repository
public class LocalidadRepositoryImpl implements LocalidadRepository{
	
	@Autowired
	private LocalidadDaoRepository localidadDaoRepository;

	@Override
	public Optional<List<Localidad>> getLocalidades(String estado) {
		// TODO Auto-generated method stub
		Optional<List<Localidad>> localidades = localidadDaoRepository.findByEstado(estado); 
		return localidades;
	}

}
