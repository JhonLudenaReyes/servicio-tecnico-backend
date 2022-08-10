package com.webservices.serviciotecnico.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservices.serviciotecnico.domain.service.RoleService;
import com.webservices.serviciotecnico.persistence.model.Role;

@RestController
@RequestMapping("/role-list")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/all-roles")
	public ResponseEntity<List<Role>> getRoles(){
		return new ResponseEntity<>(roleService.getRoles(), HttpStatus.OK);
	}
	
	@GetMapping("/active-roles")
	public ResponseEntity<List<Role>> getActiveRoles(){
		return roleService.getActiveRoles().map(rol -> new ResponseEntity<>(rol, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
