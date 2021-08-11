package com.jhanmorales.TestColfondos.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LOG")
public class Log {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="FECHA")
	private Date fecha;
	
	@Column(name="REQUEST")
	private String request;
	
	@Column(name="RESPONSE")
	private String response;
	
	@Column(name="TIPO_RESPUESTA")
	private String tipo_respuesta;

	@Column(name="fecha")
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getTipo_respuesta() {
		return tipo_respuesta;
	}

	public void setTipo_respuesta(String tipo_respuesta) {
		this.tipo_respuesta = tipo_respuesta;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Log [fecha=" + fecha + ", request=" + request + ", response=" + response + ", tipo_respuesta="
				+ tipo_respuesta + "]";
	}

}
