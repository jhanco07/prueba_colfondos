package com.jhanmorales.TestColfondos.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTE")
public class Cliente {
	

	@Id
	@Column(name="IDENTIFICACION")
	private String identificacion;
	
	//@Column(name="ID_TIPO_DOCUMENTO")
	@ManyToOne
	@JoinColumn(name="ID_TIPO_DOCUMENTO", referencedColumnName="ID")
	private TipoDocumento id_tipo_documento;	
	
	@Column(name="CORREO")
	private String correo;
	
	@Column(name="CELULAR")
	private String celular;

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public TipoDocumento getId_tipo_documento() {
		return id_tipo_documento;
	}

	public void setId_tipo_documento(TipoDocumento id_tipo_documento) {
		this.id_tipo_documento = id_tipo_documento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Override
	public String toString() {
		return "Cliente [identificacion=" + identificacion + ", id_tipo_documento=" + id_tipo_documento + ", correo="
				+ correo + ", celular=" + celular + "]";
	}

}
