package br.com.beltramejp.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.beltramejp.api.dto.UsuarioDTO;
import br.com.beltramejp.domain.entity.Usuario;
import br.com.beltramejp.domain.repository.UsuarioRepository;
import br.com.beltramejp.domain.util.CustomRepository;
import br.com.beltramejp.service.converter.UsuarioConverter;
import br.com.beltramejp.service.util.CustomConverter;
import br.com.beltramejp.service.util.DefaultCRUDService;

@Service
public class UsuarioService extends DefaultCRUDService<UsuarioDTO, Usuario, Integer> {
	
	@Autowired
	private UsuarioConverter usuarioConverter;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public static final int NUMERO_MAXIMO_LOCACAO = 5;
	
	public Integer countLocacaoByIdUsuario(Integer idUsuario) {
		return usuarioRepository.countLocacaoByIdUsuario(idUsuario);
	}
	
	@Override
	public CustomConverter<Usuario, UsuarioDTO> getConverter() {
		return usuarioConverter;
	}

	@Override
	public CustomRepository<Usuario, Integer> getRepository() {
		return usuarioRepository;
	}

}
