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

import com.webservices.serviciotecnico.domain.service.PermisoService;
import com.webservices.serviciotecnico.persistence.model.Permiso;

@RestController
@RequestMapping("/permisos")
public class PermisoController {
	
	//Permit Class

	@Autowired
	private PermisoService permisoService;

	@PostMapping("/save_permits")
	public ResponseEntity<Permiso> save(@RequestBody Permiso permiso) {
		return new ResponseEntity<>(permisoService.save(permiso), HttpStatus.CREATED);
	}

	@GetMapping("/{permitId}")
	public ResponseEntity<Permiso> getPermit(@PathVariable("permitId") int permitId) {
		return permisoService.getPermit(permitId).map(permit -> new ResponseEntity<>(permit, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@GetMapping("/all-permits")
	public ResponseEntity<List<Permiso>> findPermits() {
		return permisoService.findPermits().map(permit -> new ResponseEntity<>(permit, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PutMapping("/update-permit")
	public ResponseEntity<Permiso> updatePermit(@RequestBody Permiso permit) {
		Optional<Permiso> optionalPermit = permisoService.getPermit(permit.getIdPermiso());
		if(optionalPermit.isPresent()) {
			return new ResponseEntity<>(permisoService.save(permit), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/delete-permit-by-id/{permitId}")
	public ResponseEntity<Permiso> deletePermitById(@PathVariable("permitId") int permitId){
		Optional<Permiso> optionalPermit = permisoService.getPermit(permitId);
		if(optionalPermit.isPresent()) {
			Permiso updatePermit = optionalPermit.get();
			updatePermit.setEstado("I");
			return new ResponseEntity<>(permisoService.save(updatePermit), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
