package br.com.beltramejp.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.beltramejp.api.dto.FilmeDTO;
import br.com.beltramejp.api.util.DefaultCRUDResource;
import br.com.beltramejp.api.validator.FilmeValidator;
import br.com.beltramejp.domain.entity.Filme;
import br.com.beltramejp.service.service.FilmeService;
import br.com.beltramejp.service.service.HistoricoService;
import br.com.beltramejp.service.util.DefaultCRUDService;

@RestController
@RequestMapping("/filme")
public class FilmeResource extends DefaultCRUDResource<FilmeDTO, Filme, Integer>{

	@Autowired
	private FilmeService filmeService;
	
	@Autowired
	private FilmeValidator filmeValidator;
	
	@Autowired
	private HistoricoService historicoService;
	
	@GetMapping("/historico/{id}")
	public List<String> historicoFilme(@PathVariable("id") Integer idFilme){
		return historicoService.findHistoricoByIdFilme(idFilme);
	}
	
	@Override
	public DefaultCRUDService<FilmeDTO, Filme, Integer> getDefaultCRUDService() {
		return filmeService;
	}
	
	@Override
	protected Validator[] getValidators() {
		return new Validator[]{filmeValidator};
	}
	
}