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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Integer idUsuario;

	@Column(name = "id_persona")
	private Integer idPersona;

	@NotNull(message = "No debe enviar datos nulos")
	@NotBlank(message = "Debe ingresar un nombre sin dejar espacios en blanco")
	@Size(min = 5, message = "Debe ingresar un mínimo de 5 caráteres")
	@Size(max = 10, message = "Debe ingresar un mínimo de 10 caráteres")
	@Column(length = 10, nullable = false)
	private String usuario;

	@Column(length = 10, nullable = false)
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,10}$", message = "La contraseña debe tener al menos un número, una mayúscula, una minúscula, un carácter especial, y tener entre 8 y 10 caracteres.")
	private String contrasenia;

	@Column(columnDefinition = "varchar(1) not null default 'A'")
	private String estado = "A";

	@ManyToOne
	@JoinColumn(name = "id_persona", insertable = false, updatable = false)
	private Persona persona;

	@ManyToMany
	@JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_rol"))
	private List<Rol> roles;

}
