package com.webservices.serviciotecnico.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webservices.serviciotecnico.domain.repository.ClienteRepository;
import com.webservices.serviciotecnico.persistence.dao.ClienteDaoRepository;
import com.webservices.serviciotecnico.persistence.model.Cliente;


@Repository
public class ClienteRepositoryImpl implements ClienteRepository{
	
	@Autowired
	private ClienteDaoRepository clienteDaoRepository;

	@Override
	public Cliente save(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteDaoRepository.save(cliente);
	}

}
