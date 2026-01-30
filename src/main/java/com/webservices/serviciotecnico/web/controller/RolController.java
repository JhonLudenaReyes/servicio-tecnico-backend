package com.webservices.serviciotecnico.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservices.serviciotecnico.domain.service.RolService;
import com.webservices.serviciotecnico.persistence.model.Rol;
import com.webservices.serviciotecnico.persistence.model.entity.rol.RolSelect;

@RestController
@RequestMapping("/roles")
public class RolController {
	
	@Autowired
	private RolService rolService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/active-roles")
	public ResponseEntity<List<Rol>> getAllRoles(){
		return rolService.getRolesActive().map(rol -> new ResponseEntity<>(rol, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/save")
	public ResponseEntity<Rol> saveRol(@RequestBody Rol rol){
		return new ResponseEntity<>(rolService.saveRol(rol), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update-role")
	public ResponseEntity<Rol> updateRole(@RequestBody Rol rol){
		Optional<Rol> optionalRole = rolService.getRole(rol.getIdRol());
		if(optionalRole.isPresent()) {
			return new ResponseEntity<>(rolService.saveRol(rol), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
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
	
	//Controlador para los metodos de la entidad RolSelect
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/roles-select")
	public ResponseEntity<List<RolSelect>> getActiveRoles(){
		return rolService.getRolesSelect().map(rol -> new ResponseEntity<>(rol, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
