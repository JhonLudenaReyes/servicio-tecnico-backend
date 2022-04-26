package com.webservices.serviciotecnico.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservices.serviciotecnico.domain.repository.ClienteRepository;
import com.webservices.serviciotecnico.persistence.model.Cliente;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

}
