package com.webservices.serviciotecnico.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservices.serviciotecnico.persistence.model.Permit;

public interface PermitDaoRepository extends JpaRepository<Permit, Integer>{

}
