package com.jhanmorales.TestColfondos.manager;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jhanmorales.TestColfondos.entities.Cliente;
import com.jhanmorales.TestColfondos.entities.Log;
import com.jhanmorales.TestColfondos.entities.TipoDocumento;
import com.jhanmorales.TestColfondos.repositories.ClienteRepository;
import com.jhanmorales.TestColfondos.repositories.LogRepository;
import com.jhanmorales.TestColfondos.repositories.TipoDocumentoRepository;
import com.jhanmorales.TestColfondos.util.BusinessException;
import com.jhanmorales.TestColfondos.util.ClienteFacade;
import com.jhanmorales.TestColfondos.util.TipoDocumentosFacade;

@Service
public class Business {

	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private LogRepository logRepository;

	public List<TipoDocumento> getAllTipoDocumento() throws BusinessException {

		final List<TipoDocumento> littDocumento = new ArrayList<>();
		try {

			tipoDocumentoRepository.findAll().forEach((t) -> {
				littDocumento.add(t);
				System.out.println("Count:::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			});
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BusinessException("Ocurrio un error en la base de datos- Consulta TipoDocumento", ex.getCause());
		}

		return littDocumento;

	}

	public List<Cliente> getAllClient() throws BusinessException {

		List<Cliente> clientes = new ArrayList<>();

		try {
			clienteRepository.findAll().forEach(clientes::add);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BusinessException("Ocurrio un error en la base de datos- Consulta Clientes", ex.getCause());
		}
		return clientes;
	}

	public String saveCliente(ClienteFacade clienteFacade) throws BusinessException {

		Cliente cliente= new Cliente();
		try {
			
			cliente.setCelular(clienteFacade.getCelular());
			cliente.setCorreo(clienteFacade.getCorreo());
			TipoDocumento id_tipo_documento =tipoDocumentoRepository.findOne(clienteFacade.getIdTipoDocumento());
			cliente.setId_tipo_documento(id_tipo_documento );
			cliente.setIdentificacion(clienteFacade.getCedula());
			
			clienteRepository.save(cliente);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BusinessException("Ocurrio un error en la base de datos- guardando cliente ", ex.getCause());
		}
		return cliente.getIdentificacion();
	}
	
	@Async
	public void guardarLog(Object request, Object response, String tipo_respuesta) {
		
	
		try {
			ObjectMapper Obj = new ObjectMapper();			
			String strRequest = Obj.writeValueAsString(request);
			String strResponse = Obj.writeValueAsString(response);
			Log log = new Log();
			log.setRequest(strRequest);
			log.setResponse(strResponse);
			log.setTipo_respuesta(tipo_respuesta);
			
			logRepository.save(log );
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
	}
 
	
	
	

	
	
}
