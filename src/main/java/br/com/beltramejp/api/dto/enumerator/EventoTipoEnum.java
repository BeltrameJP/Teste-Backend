package br.com.beltramejp.api.dto.enumerator;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;


public enum EventoTipoEnum implements Serializable{
	LOCACAO(1, "Locação"), 
	RENOVACAO(2, "Renovação"), 
	DEVOLUCAO(3, "Devolução");
	
	private Integer codigo;
	private String descricao;
	
	private EventoTipoEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	@JsonCreator
	public static EventoTipoEnum getEnumByCodigo(Integer codigo) {
		for(EventoTipoEnum e : EventoTipoEnum.values()) {
			if(e.getCodigo().equals(codigo)) {
				return e;
			}
		}
		return null;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
