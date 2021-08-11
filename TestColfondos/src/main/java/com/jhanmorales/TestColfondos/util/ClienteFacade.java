package com.jhanmorales.TestColfondos.util;

public class ClienteFacade {
	
	private String cedula;
	private Long idTipoDocumento;
	private String correo;
	private String celular;
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public Long getIdTipoDocumento() {
		return idTipoDocumento;
	}
	public void setIdTipoDocumento(Long idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
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
		return "ClienteFacade [cedula=" + cedula + ", idTipoDocumento=" + idTipoDocumento + ", correo=" + correo
				+ ", celular=" + celular + "]";
	}
}
