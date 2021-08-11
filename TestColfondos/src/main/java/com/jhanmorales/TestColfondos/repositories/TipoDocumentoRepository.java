package com.jhanmorales.TestColfondos.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jhanmorales.TestColfondos.entities.TipoDocumento;

@Repository
public interface TipoDocumentoRepository extends CrudRepository<TipoDocumento, Long> {
	
	 @Query("select t from TipoDocumento t where t.id = ?1")
	 TipoDocumento findOne(Long id);
}