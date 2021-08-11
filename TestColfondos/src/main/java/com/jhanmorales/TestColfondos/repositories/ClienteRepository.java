package com.jhanmorales.TestColfondos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jhanmorales.TestColfondos.entities.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, String> {
}
