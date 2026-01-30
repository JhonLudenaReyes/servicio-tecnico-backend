package com.webservices.serviciotecnico.persistence.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table(name = "roles")
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rol")
	private Integer idRol;
	
	@NotNull(message = "No debe enviar datos nulos")
	@Size(min = 5, message = "Debe ingresar un mínimo de 5 caráteres")
	@Size(max = 20, message = "Debe ingresar un máximo de 20 caráteres")
	@Column(length = 20, nullable = false)
	private String rol;
	
	@Column(columnDefinition = "varchar(1) not null default 'A'")
	private String estado = "A";
	
	@ManyToMany
	@JoinTable(name= "roles_permisos", joinColumns = @JoinColumn(name="id_rol"), inverseJoinColumns = @JoinColumn(name="id_permiso"))
	private List<Permiso> permisos;

}
