package com.webservices.serviciotecnico.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservices.serviciotecnico.domain.service.ClienteService;
import com.webservices.serviciotecnico.persistence.model.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/save-client")
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
		return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.CREATED);
	}

}
