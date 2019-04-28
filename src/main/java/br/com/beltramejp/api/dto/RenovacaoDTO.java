package br.com.beltramejp.api.dto;

import java.io.Serializable;

public class RenovacaoDTO implements Serializable{

	private static final long serialVersionUID = 8281289609537524087L;
	
	private Integer idLocacao;
	
	private Integer adiamentoDias;

	public Integer getIdLocacao() {
		return idLocacao;
	}

	public void setIdLocacao(Integer idLocacao) {
		this.idLocacao = idLocacao;
	}

	public Integer getAdiamentoDias() {
		return adiamentoDias;
	}

	public void setAdiamentoDias(Integer adiamentoDias) {
		this.adiamentoDias = adiamentoDias;
	}
	
}
