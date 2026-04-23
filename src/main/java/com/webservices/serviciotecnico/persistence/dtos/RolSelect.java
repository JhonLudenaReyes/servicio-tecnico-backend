package com.webservices.serviciotecnico.persistence.dtos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "roles")
public class RolSelect {
	
	@Id
	@Column(name = "id_rol")
	private Integer idRol;
	
	private String rol;

}
