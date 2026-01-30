package com.webservices.serviciotecnico.persistence.dao.other.rol;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.webservices.serviciotecnico.persistence.model.entity.rol.RolSelect;

public interface RolSelectDaoRepository extends JpaRepository<RolSelect, Integer>{
	
	@Query(value = "select id_rol, rol from roles where estado = 'A'", nativeQuery = true)
	Optional<List<RolSelect>> getRolesSelect();

}
