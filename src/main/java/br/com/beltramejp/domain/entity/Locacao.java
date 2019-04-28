package br.com.beltramejp.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import br.com.beltramejp.domain.util.Identifiable;

@Entity
@Table(name = "locacao")
@Where(clause = " tag_deletado = false ")
public class Locacao implements Identifiable{

	private static final long serialVersionUID = 5623796885517867125L;
	
	@Id @GeneratedValue
	@Column(name = "id_locacao")
	private Integer idLocacao;

	@Column(name = "data_locacao")
	private Date dataLocacao;

	@Column(name = "data_devolucao")
	private Date dataDevolucao;

	@Column(name = "tag_devolvido")
	private Boolean tagDevolvido;
	
	private Integer renovacao;

	@Column(name = "tag_deletado")
	private Boolean tagDeletado = false;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_filme")
	private Filme filme;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@Override
	public Integer getId() {
		return idLocacao;
	}

	public Integer getIdLocacao() {
		return idLocacao;
	}

	public void setIdLocacao(Integer idLocacao) {
		this.idLocacao = idLocacao;
	}

	public Date getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Boolean getTagDevolvido() {
		return tagDevolvido;
	}

	public void setTagDevolvido(Boolean tagDevolvido) {
		this.tagDevolvido = tagDevolvido;
	}

	public Boolean getTagDeletado() {
		return tagDeletado;
	}

	public void setTagDeletado(Boolean tagDeletado) {
		this.tagDeletado = tagDeletado;
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

	public Integer getRenovacao() {
		return renovacao;
	}

	public void setRenovacao(Integer renovacao) {
		this.renovacao = renovacao;
	}

}
