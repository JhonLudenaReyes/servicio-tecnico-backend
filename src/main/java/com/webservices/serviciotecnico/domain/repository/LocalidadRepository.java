package com.webservices.serviciotecnico.domain.repository;

import java.util.List;
import java.util.Optional;

import com.webservices.serviciotecnico.persistence.model.Localidad;

public interface LocalidadRepository {

	Optional<List<Localidad>> getLocalidades(String estado);
}
