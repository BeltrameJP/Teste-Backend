package br.com.beltramejp.service.converter;

import org.springframework.stereotype.Component;

import br.com.beltramejp.api.dto.FilmeDTO;
import br.com.beltramejp.domain.entity.Filme;
import br.com.beltramejp.service.util.CustomConverter;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Component
public class FilmeConverter extends CustomConverter<Filme, FilmeDTO>{

	private MapperFactory mapperFactory;
	private MapperFacade mapperFacade;
	
	public FilmeConverter() {
		mapperFactory = new DefaultMapperFactory.Builder().build();
		
		mapperFactory.classMap(Filme.class, FilmeDTO.class)
			.byDefault().register();
		
		mapperFacade = mapperFactory.getMapperFacade();
	}
	
	@Override
	public Filme convertDTO(FilmeDTO entity) {
		return mapperFacade.map(entity, Filme.class);
	}

	@Override
	public FilmeDTO convertDAO(Filme entity) {
		return mapperFacade.map(entity, FilmeDTO.class);
	}

}
