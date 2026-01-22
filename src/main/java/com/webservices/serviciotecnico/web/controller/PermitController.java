package com.webservices.serviciotecnico.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservices.serviciotecnico.domain.service.PermitService;
import com.webservices.serviciotecnico.persistence.model.Permit;

@RestController
@RequestMapping("/permits")
public class PermitController {
	
	@Autowired
	private PermitService permitService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/all-permits")
	public ResponseEntity<List<Permit>> getPermits(){
		return permitService.getPermits().map( permits -> new ResponseEntity<>(permits, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/save-permit")
	public ResponseEntity<Permit> save(@RequestBody Permit permit){
		return new ResponseEntity<>(permitService.save(permit),HttpStatus.CREATED);
	}

}
