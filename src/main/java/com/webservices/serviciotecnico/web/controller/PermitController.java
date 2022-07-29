package com.webservices.serviciotecnico.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservices.serviciotecnico.domain.service.PermitService;
import com.webservices.serviciotecnico.persistence.model.Permit;

@RestController
@RequestMapping("/permits")
public class PermitController {
	
	@Autowired
	private PermitService permitService;
	
	@GetMapping("/all-permits")
	public ResponseEntity<List<Permit>> getPermits(){
		return new ResponseEntity<>(permitService.getPermits(), HttpStatus.OK);
	}

}
