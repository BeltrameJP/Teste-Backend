package br.com.beltramejp.domain.repository;

import org.springframework.data.jpa.repository.Query;

import br.com.beltramejp.domain.entity.Usuario;
import br.com.beltramejp.domain.util.CustomRepository;

public interface UsuarioRepository extends CustomRepository<Usuario, Integer>{
	
	@Query("select count(l) from Usuario u"
			+ "	join u.locacao l"
			+ "	where l.tagDeletado = false "
			+ "		and l.tagDevolvido = false "
			+ "		and u.idUsuario = ?1 ")
	public Integer countLocacaoByIdUsuario(Integer idUsuario);
	
}
