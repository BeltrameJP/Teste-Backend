package br.com.beltramejp.api.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.beltramejp.api.dto.enumerator.EventoTipoEnum;

public class HistoricoDTO implements Serializable{

	private static final long serialVersionUID = 7708892153279052844L;

	private Integer idHistorico;
	
	private Date dataEvento;
	
	private EventoTipoEnum eventoTipo;
	
	private FilmeDTO filme;

	private UsuarioDTO usuario;

	public Integer getIdHistorico() {
		return idHistorico;
	}

	public void setIdHistorico(Integer idHistorico) {
		this.idHistorico = idHistorico;
	}

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public EventoTipoEnum getEventoTipo() {
		return eventoTipo;
	}

	public void setEventoTipo(EventoTipoEnum eventoTipo) {
		this.eventoTipo = eventoTipo;
	}

	public FilmeDTO getFilme() {
		return filme;
	}

	public void setFilme(FilmeDTO filme) {
		this.filme = filme;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	
}
