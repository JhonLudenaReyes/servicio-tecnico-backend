package com.webservices.serviciotecnico.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservices.serviciotecnico.domain.service.RolService;
import com.webservices.serviciotecnico.persistence.model.Rol;

@RestController
@RequestMapping("/roles")
public class RolController {
	
	@Autowired
	private RolService rolService;
	
	@GetMapping("/active-roles")
	public ResponseEntity<List<Rol>> getAllRoles(){
		return rolService.getRolesActive().map(rol -> new ResponseEntity<>(rol, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/get-roles")
	public ResponseEntity<List<Rol>> getRoles(){
		return rolService.getRoles().map(rol -> new ResponseEntity<>(rol, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/save")
	public ResponseEntity<Rol> saveRol(@RequestBody Rol rol){
		return new ResponseEntity<>(rolService.saveRol(rol), HttpStatus.OK);
	}
	
	@PutMapping("/update-role")
	public ResponseEntity<Rol> updateRole(@RequestBody Rol rol){
		Optional<Rol> optionalRole = rolService.getRole(rol.getIdRol());
		if(optionalRole.isPresent()) {
			return new ResponseEntity<>(rolService.saveRol(rol), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/delete-role/{idRole}")
	public ResponseEntity<Rol> deleteRole(@PathVariable("idRole") int idRole){
		Optional<Rol> optionalRole = rolService.getRole(idRole);
		if(optionalRole.isPresent()) {
			Rol updateRole = optionalRole.get();
			updateRole.setEstado("I");
			return new ResponseEntity<>(rolService.saveRol(updateRole), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
