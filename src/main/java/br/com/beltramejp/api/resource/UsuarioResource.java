package br.com.beltramejp.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.beltramejp.api.dto.UsuarioDTO;
import br.com.beltramejp.api.util.DefaultCRUDResource;
import br.com.beltramejp.api.validator.UsuarioValidator;
import br.com.beltramejp.domain.entity.Usuario;
import br.com.beltramejp.service.service.HistoricoService;
import br.com.beltramejp.service.service.UsuarioService;
import br.com.beltramejp.service.util.DefaultCRUDService;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource extends DefaultCRUDResource<UsuarioDTO, Usuario, Integer>{
	
	@Autowired
	private UsuarioValidator usuarioValidator;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private HistoricoService historicoService;
	
	@GetMapping("/historico/{id}")
	public List<String> historicoFilme(@PathVariable("id") Integer idUsuario){
		return historicoService.findHistoricoByIdUsuario(idUsuario);
	}
	
	@Override
	public DefaultCRUDService<UsuarioDTO, Usuario, Integer> getDefaultCRUDService() {
		return usuarioService;
	}

	@Override
	protected Validator[] getValidators() {
		return new Validator[]{usuarioValidator};
	}
	
	
	
}
