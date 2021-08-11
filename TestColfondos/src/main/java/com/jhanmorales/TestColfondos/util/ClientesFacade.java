package com.jhanmorales.TestColfondos.util;

import java.util.List;

import com.jhanmorales.TestColfondos.entities.Cliente;

public class ClientesFacade {
	
	public Cabecera cabecera;
	public List<Cliente> clientes;
	
	public Cabecera getCabecera() {
		return cabecera;
	}
	public void setCabecera(Cabecera cabecera) {
		this.cabecera = cabecera;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	

}
