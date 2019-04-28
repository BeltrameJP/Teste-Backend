package br.com.beltramejp.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.beltramejp.api.dto.enumerator.EventoTipoEnum;
import br.com.beltramejp.domain.converter.EventoTipoConverter;
import br.com.beltramejp.domain.util.Identifiable;

@Entity
@Table(name = "historico")
public class Historico implements Identifiable{
	
	private static final long serialVersionUID = -8034007268282807540L;

	@Id @GeneratedValue
	@Column(name = "id_historico")
	private Integer idHistorico;
	
	@Column(name = "data_evento")
	private Date dataEvento;
	
	@Convert(converter = EventoTipoConverter.class)
	@Column(name = "evento_tipo")
	private EventoTipoEnum eventoTipo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_filme")
	private Filme filme;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

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

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public Integer getId() {
		return idHistorico;
	}
	
	
}
