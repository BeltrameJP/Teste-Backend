package br.com.beltramejp.domain.repository;

import org.springframework.data.jpa.repository.Query;

import br.com.beltramejp.domain.entity.Filme;
import br.com.beltramejp.domain.util.CustomRepository;

public interface FilmeRepository extends CustomRepository<Filme, Integer> {

	@Query(value = "select f.quantidade from Filme f " 
			+ "			join f.locacao l "
			+ "		where l.tagDeletado = false " 
			+ "			and l.tagDevolvido = false 	"
			+ "			and f.idFilme = ?1 ")
	public Object[] findQuantidadeFilmeAndCountLocacaoByIdFilme(Integer idFilme);

}
