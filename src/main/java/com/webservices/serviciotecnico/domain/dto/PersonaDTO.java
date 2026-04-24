package com.webservices.serviciotecnico.domain.dto;

import lombok.Data;

@Data
public class PersonaDTO {
    private Integer idPersona;
    private String nombres;
    private String apellidos;
    private String cedula;
    private String email;
    private String celular;
    private String estado;
}
