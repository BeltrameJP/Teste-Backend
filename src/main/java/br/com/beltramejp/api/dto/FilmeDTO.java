package br.com.beltramejp.api.dto;

import java.io.Serializable;

public class FilmeDTO implements Serializable{

	private static final long serialVersionUID = -4818842841498135425L;

	public Integer idFilme;
	
	public String nome;
	
	public String diretor;
	
	public Integer quantidade;
	
	public Boolean tagDeletado = false;

	public String genero;

	public Integer getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(Integer idFilme) {
		this.idFilme = idFilme;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Boolean getTagDeletado() {
		return tagDeletado;
	}

	public void setTagDeletado(Boolean tagDeletado) {
		this.tagDeletado = tagDeletado;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}
