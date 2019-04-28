package br.com.beltramejp.api.dto;

import java.io.Serializable;
import java.util.Date;

public class UsuarioDTO implements Serializable{

	private static final long serialVersionUID = 1791226159733412942L;

	private Integer idUsuario;
	
	private String nome;
	
	private String sexo;

	private String cpf;
	
	private Date dataNascimento;
	
	public Boolean tagDeletado = false;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Boolean getTagDeletado() {
		return tagDeletado;
	}

	public void setTagDeletado(Boolean tagDeletado) {
		this.tagDeletado = tagDeletado;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
