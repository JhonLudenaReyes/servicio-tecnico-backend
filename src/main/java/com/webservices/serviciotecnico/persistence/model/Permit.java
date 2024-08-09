package com.webservices.serviciotecnico.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "permisos")
public class Permit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id_permiso")
	private Integer idPermiso;
	
	private String permiso;

	private String estado = "A";

	public Integer getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(Integer idPermiso) {
		this.idPermiso = idPermiso;
	}

	public String getPermiso() {
		return permiso;
	}

	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
