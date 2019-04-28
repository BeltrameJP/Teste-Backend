package br.com.beltramejp.service.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.beltramejp.api.dto.LocacaoDTO;
import br.com.beltramejp.domain.entity.Locacao;
import br.com.beltramejp.service.util.CustomConverter;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Component
public class LocacaoConverter extends CustomConverter<Locacao, LocacaoDTO>{

	private MapperFactory mapperFactory;
	private MapperFacade mapperFacade;
	
	@Autowired
	private FilmeConverter filmeConverter;
	
	@Autowired
	private UsuarioConverter usuarioConverter;
	
	public LocacaoConverter() {
		mapperFactory = new DefaultMapperFactory.Builder().build();
		
		mapperFactory.classMap(Locacao.class, LocacaoDTO.class)
			.customize(new CustomMapper<Locacao,LocacaoDTO>() {
				@Override
				public void mapAtoB(Locacao a, LocacaoDTO b, MappingContext context) {
					usuarioConverter.mapAtoB(a.getUsuario(), b.getUsuario(), context);
					filmeConverter.mapAtoB(a.getFilme(), b.getFilme(), context);
				}
			})
			.byDefault().register();
		
		mapperFacade = mapperFactory.getMapperFacade();
	}
	
	@Override
	public Locacao convertDTO(LocacaoDTO entity) {
		return mapperFacade.map(entity, Locacao.class);
	}

	@Override
	public LocacaoDTO convertDAO(Locacao entity) {
		return mapperFacade.map(entity, LocacaoDTO.class);
	}
}
