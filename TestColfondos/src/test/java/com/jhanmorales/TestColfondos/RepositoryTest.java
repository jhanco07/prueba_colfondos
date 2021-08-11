package com.jhanmorales.TestColfondos;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.jhanmorales.TestColfondos.entities.Cliente;
import com.jhanmorales.TestColfondos.entities.TipoDocumento;
import com.jhanmorales.TestColfondos.manager.Business;
import com.jhanmorales.TestColfondos.repositories.ClienteRepository;
import com.jhanmorales.TestColfondos.repositories.TipoDocumentoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
class RepositoryTest {
	
	@Autowired
	private Business business;
	
	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;

	@SuppressWarnings("deprecation")
	@Test
	void testTipoDocumento()  throws Exception {
		Cliente cliente= new Cliente();
		cliente.setCelular("311111111");
		cliente.setCorreo("prueba@prueba.com");
		TipoDocumento id_tipo_documento =tipoDocumentoRepository.findOne(1L);
		cliente.setId_tipo_documento(id_tipo_documento );
		cliente.setIdentificacion("11111111111");
		business.saveCliente(cliente);
		assertThat(cliente.getIdentificacion()).isNotNull();
		
	}

}
