package com.webservices.serviciotecnico.domain.mapper;

import org.mapstruct.Mapper;
import com.webservices.serviciotecnico.domain.dto.UsuarioDTO;
import com.webservices.serviciotecnico.domain.dto.PersonaDTO;
import com.webservices.serviciotecnico.domain.dto.RolDTO;
import com.webservices.serviciotecnico.persistence.model.Usuario;
import com.webservices.serviciotecnico.persistence.model.Persona;
import com.webservices.serviciotecnico.persistence.model.Rol;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioDTO toDTO(Usuario usuario);
    
    Usuario toEntity(UsuarioDTO dto);

    PersonaDTO toDTO(Persona persona);
    
    Persona toEntity(PersonaDTO dto);

    RolDTO toDTO(Rol rol);
    
    Rol toEntity(RolDTO dto);
}
