package br.com.beltramejp.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.beltramejp.api.dto.FilmeDTO;
import br.com.beltramejp.domain.entity.Filme;
import br.com.beltramejp.domain.repository.FilmeRepository;
import br.com.beltramejp.domain.util.CustomRepository;
import br.com.beltramejp.service.converter.FilmeConverter;
import br.com.beltramejp.service.util.CustomConverter;
import br.com.beltramejp.service.util.DefaultCRUDService;

@Service
public class FilmeService extends DefaultCRUDService<FilmeDTO, Filme, Integer> {

	@Autowired
	private FilmeConverter filmeConverter;
	
	@Autowired
	private FilmeRepository filmeRepository;
	
	public Object[] findQuantidadeFilmeAndCountLocacaoByIdFilme(Integer idFilme){
		return filmeRepository.findQuantidadeFilmeAndCountLocacaoByIdFilme(idFilme);
	}
	
	@Override
	public CustomConverter<Filme, FilmeDTO> getConverter() {
		return filmeConverter;
	}

	@Override
	public CustomRepository<Filme, Integer> getRepository() {
		return filmeRepository;
	}
}