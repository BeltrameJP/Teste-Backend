package br.com.beltramejp.service.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.beltramejp.api.dto.HistoricoDTO;
import br.com.beltramejp.domain.entity.Historico;
import br.com.beltramejp.service.util.CustomConverter;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Component
public class HistoricoConverter extends CustomConverter<Historico, HistoricoDTO>{

	private MapperFactory mapperFactory;
	private MapperFacade mapperFacade;
	
	@Autowired
	private FilmeConverter filmeConverter;
	
	@Autowired
	private UsuarioConverter usuarioConverter;
	
	public HistoricoConverter() {
		mapperFactory = new DefaultMapperFactory.Builder().build();
		
		mapperFactory.classMap(Historico.class, HistoricoDTO.class)
			.customize(new CustomMapper<Historico,HistoricoDTO>() {
				@Override
				public void mapAtoB(Historico a, HistoricoDTO b, MappingContext context) {
					usuarioConverter.mapAtoB(a.getUsuario(), b.getUsuario(), context);
					filmeConverter.mapAtoB(a.getFilme(), b.getFilme(), context);
				}
			})
			.byDefault().register();
		
		mapperFacade = mapperFactory.getMapperFacade();
	}
	
	@Override
	public Historico convertDTO(HistoricoDTO entity) {
		return mapperFacade.map(entity, Historico.class);
	}

	@Override
	public HistoricoDTO convertDAO(Historico entity) {
		return mapperFacade.map(entity, HistoricoDTO.class);
	}
}