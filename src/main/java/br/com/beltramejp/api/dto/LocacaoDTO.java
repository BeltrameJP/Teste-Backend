package br.com.beltramejp.api.dto;

import java.io.Serializable;
import java.util.Date;

public class LocacaoDTO implements Serializable{
	
	private static final long serialVersionUID = -5588586331125553444L;

	private Integer idLocacao;

	private Date dataLocacao;

	private Date dataDevolucao;

	private Boolean tagDevolvido;

	private Boolean tagDeletado = false;
	
	private Integer renovacao;

	private FilmeDTO filme;

	private UsuarioDTO usuario;

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

	public Integer getRenovacao() {
		return renovacao;
	}

	public void setRenovacao(Integer renovacao) {
		this.renovacao = renovacao;
	}
	
}
