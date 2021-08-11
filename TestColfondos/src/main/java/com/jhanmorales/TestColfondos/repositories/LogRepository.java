package com.jhanmorales.TestColfondos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jhanmorales.TestColfondos.entities.Log;


@Repository
public interface LogRepository extends CrudRepository<Log, Long> {

}
