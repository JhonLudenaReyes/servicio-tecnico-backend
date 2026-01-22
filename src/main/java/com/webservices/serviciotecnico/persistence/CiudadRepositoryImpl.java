package com.webservices.serviciotecnico.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webservices.serviciotecnico.domain.repository.CiudadRepository;
import com.webservices.serviciotecnico.persistence.dao.CiudadDaoRepository;
import com.webservices.serviciotecnico.persistence.model.Ciudad;

@Repository
public class CiudadRepositoryImpl implements CiudadRepository{
	
	@Autowired
	private CiudadDaoRepository ciudadDaoRepository;

	@Override
	public Optional<List<Ciudad>> getCiudades(String estado) {
		// TODO Auto-generated method stub
		Optional<List<Ciudad>> ciudades = ciudadDaoRepository.findByEstado(estado); 
		return ciudades;
	}

}
