package br.com.beltramejp.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import br.com.beltramejp.domain.entity.Historico;
import br.com.beltramejp.domain.util.CustomRepository;

public interface HistoricoRepository extends CustomRepository<Historico, Integer> {

	@Query("from Historico o where o.filme.idFilme = ?1")
	public List<Historico> findHistoricoByIdFilme(Integer idFilme);

	@Query("from Historico o where o.usuario.idUsuario = ?1")
	public List<Historico> findHistoricoByIdUsuario(Integer idUsuario);
}
