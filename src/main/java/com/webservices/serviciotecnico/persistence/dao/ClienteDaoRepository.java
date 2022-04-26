package com.webservices.serviciotecnico.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservices.serviciotecnico.persistence.model.Cliente;

public interface ClienteDaoRepository extends JpaRepository<Cliente, Integer>{

}
