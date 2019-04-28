package br.com.beltramejp.domain.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import br.com.beltramejp.domain.util.Identifiable;


@Entity
@Table(name = "filme")
@Where(clause = " tag_deletado = false ")
public class Filme implements Identifiable{

	private static final long serialVersionUID = -2784972156301211294L;

	@Id @GeneratedValue
	@Column(name = "id_filme")
	private Integer idFilme;
	
	private String nome;
	
	private String diretor;
	
	private Integer quantidade;

	private String genero;
	
	@Column(name = "tag_deletado")
	private Boolean tagDeletado = false;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "filme")
	private List<Locacao> locacao;
	
	@Override
	public Integer getId() {
		return idFilme;
	}


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


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
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
		result = prime * result + ((idFilme == null) ? 0 : idFilme.hashCode());
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
		Filme other = (Filme) obj;
		if (idFilme == null) {
			if (other.idFilme != null)
				return false;
		} else if (!idFilme.equals(other.idFilme))
			return false;
		return true;
	}
	
}
