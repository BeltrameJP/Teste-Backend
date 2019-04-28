package br.com.beltramejp.service.converter;

import org.springframework.stereotype.Component;

import br.com.beltramejp.api.dto.UsuarioDTO;
import br.com.beltramejp.domain.entity.Usuario;
import br.com.beltramejp.service.util.CustomConverter;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Component
public class UsuarioConverter extends CustomConverter<Usuario, UsuarioDTO>{

	private MapperFactory mapperFactory;
	private MapperFacade mapperFacade;
	
	public UsuarioConverter() {
		mapperFactory = new DefaultMapperFactory.Builder().build();
		
		mapperFactory.classMap(Usuario.class, UsuarioDTO.class)
			.byDefault().register();
		
		mapperFacade = mapperFactory.getMapperFacade();
	}
	
	@Override
	public Usuario convertDTO(UsuarioDTO entity) {
		return mapperFacade.map(entity, Usuario.class);
	}

	@Override
	public UsuarioDTO convertDAO(Usuario entity) {
		return mapperFacade.map(entity, UsuarioDTO.class);
	}	
}
