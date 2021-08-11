package com.jhanmorales.TestColfondos.util;

import java.util.List;

import com.jhanmorales.TestColfondos.entities.TipoDocumento;

public class TipoDocumentosFacade {
	
	public Cabecera cabecera;
	
	public List<TipoDocumento> tiposDocumento;

	public Cabecera getCabecera() {
		return cabecera;
	}

	public void setCabecera(Cabecera cabecera) {
		this.cabecera = cabecera;
	}

	public List<TipoDocumento> getTiposDocumento() {
		return tiposDocumento;
	}

	public void setTiposDocumento(List<TipoDocumento> tiposDocumento) {
		this.tiposDocumento = tiposDocumento;
	}

}
