package com.jhanmorales.TestColfondos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jhanmorales.TestColfondos.entities.Cliente;
import com.jhanmorales.TestColfondos.manager.Business;
import com.jhanmorales.TestColfondos.util.BusinessException;
import com.jhanmorales.TestColfondos.util.Cabecera;
import com.jhanmorales.TestColfondos.util.ClienteFacade;
import com.jhanmorales.TestColfondos.util.ClientesFacade;
import com.jhanmorales.TestColfondos.util.TipoDocumentosFacade;


@RestController
public class StartController {

	@Autowired
	private Business business;
	
	@CrossOrigin(origins = "*")
	@GetMapping(value="getAllTipoDocumento")
	public ResponseEntity<TipoDocumentosFacade> getAllTipoDocumento(){
		TipoDocumentosFacade tipoDocumentosFacade= new TipoDocumentosFacade();		
		Cabecera cabecera = new Cabecera();
		HttpStatus stat=null;
		
	try {
			tipoDocumentosFacade.setTiposDocumento(business.getAllTipoDocumento());
			cabecera.setTipoRespuesta("OK");
			stat=HttpStatus.OK;
		}catch(BusinessException ex) {
			cabecera.setTipoRespuesta("ER");
			cabecera.setDescError(ex.getMessage());
			stat=HttpStatus.INTERNAL_SERVER_ERROR;
		}catch(Exception ex) {
			cabecera.setTipoRespuesta("ER");
			cabecera.setDescError("Ocurrio un error inesperado: "+ ex.getMessage());
			stat=HttpStatus.INTERNAL_SERVER_ERROR;
		}finally {
			tipoDocumentosFacade.setCabecera(cabecera);
		}
		
	    business.guardarLog("", tipoDocumentosFacade, cabecera.getTipoRespuesta());
		return new ResponseEntity<TipoDocumentosFacade>(tipoDocumentosFacade,stat);
		
	
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(value="getAllClientes")
	public ResponseEntity<ClientesFacade> getAllClientes(){
		ClientesFacade clientesFacade= new ClientesFacade();		
		Cabecera cabecera = new Cabecera();
		HttpStatus stat=null;
		
	try {
			clientesFacade.setClientes(business.getAllClient());
			cabecera.setTipoRespuesta("OK");

			stat=HttpStatus.OK;
		}catch(BusinessException ex) {
			cabecera.setTipoRespuesta("ER");
			cabecera.setDescError(ex.getMessage());
			stat=HttpStatus.INTERNAL_SERVER_ERROR;
		}catch(Exception ex) {
			cabecera.setTipoRespuesta("ER");
			cabecera.setDescError("Ocurrio un error inesperado: "+ ex.getMessage());
			stat=HttpStatus.INTERNAL_SERVER_ERROR;
		}finally {
			clientesFacade.setCabecera(cabecera);
		}
	
	    business.guardarLog("", clientesFacade, cabecera.getTipoRespuesta());
		return new ResponseEntity<ClientesFacade>(clientesFacade,stat);
	
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(value="saveCliente")
	public ResponseEntity<Cabecera> saveCliente(@RequestBody ClienteFacade cliente) {
		Cabecera cabecera = new Cabecera();
		HttpStatus stat=null;
		try {
			
			business.saveCliente(cliente);
			stat=HttpStatus.OK;
			cabecera.setTipoRespuesta("OK");
		}catch(BusinessException ex) {
			cabecera.setTipoRespuesta("ER");
			cabecera.setDescError(ex.getMessage());
			stat=HttpStatus.INTERNAL_SERVER_ERROR;
		}catch(Exception ex) {
			cabecera.setTipoRespuesta("ER");
			cabecera.setDescError("Ocurrio un error inesperado: "+ ex.getMessage());
			stat=HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		business.guardarLog(cliente, cabecera, cabecera.getTipoRespuesta());
		//stat=HttpStatus.OK;
		//cabecera.setTipoRespuesta("OK");
		return new ResponseEntity<Cabecera>(cabecera,stat);
		
	}
	

}
