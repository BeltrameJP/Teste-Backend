package br.com.beltramejp.domain.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.br.CPF;

import br.com.beltramejp.domain.util.Identifiable;

@Entity
@Table(name = "usuario")
@SQLDelete(sql = " update usuario u set u.tag_deletado = true where u.id_usuario = ? ")
@Where(clause = " tag_deletado = false ")
public class Usuario implements Identifiable{

	private static final long serialVersionUID = -6403985171831187472L;

	@Id @GeneratedValue
	@Column(name = "id_usuario")
	private Integer idUsuario;
	
	private String nome;
	
	private String sexo;

	@CPF
	private String cpf;
	
	@Column(name = "data_nascimento")
	private Date dataNascimento;
	
	@Column(name = "tag_deletado")
	public Boolean tagDeletado = false;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private List<Locacao> locacao;
	
	@Override
	public Integer getId() {
		return idUsuario;
	}

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
	
	public List<Locacao> getLocacao() {
		return locacao;
	}

	public void setLocacao(List<Locacao> locacao) {
		this.locacao = locacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}
	
	
	
}
