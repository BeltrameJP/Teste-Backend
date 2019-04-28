package br.com.beltramejp.api.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.beltramejp.api.dto.LocacaoDTO;
import br.com.beltramejp.api.dto.RenovacaoDTO;
import br.com.beltramejp.api.util.DefaultCRUDResource;
import br.com.beltramejp.api.validator.LocacaoValidator;
import br.com.beltramejp.api.validator.RenovacaoValidator;
import br.com.beltramejp.domain.entity.Locacao;
import br.com.beltramejp.service.service.HistoricoService;
import br.com.beltramejp.service.service.LocacaoService;
import br.com.beltramejp.service.util.DefaultCRUDService;

@RestController
@RequestMapping("/locacao")
public class LocacaoResource extends DefaultCRUDResource<LocacaoDTO, Locacao, Integer> {

	@Autowired
	private LocacaoService locacaoService;

	@Autowired
	private LocacaoValidator locacaoValidator;

	@Autowired
	private RenovacaoValidator renovacaoValidator;
	
	@Autowired
	private HistoricoService historicoService;
	
	@GetMapping("/historico")
	public List<String> historicoFilme(){
		return historicoService.findAllString();
	}
	
	@PostMapping("/renovacao") 
	private LocacaoDTO renovacaoLocacao(@RequestBody @Valid RenovacaoDTO dto) {
		return locacaoService.renovacaoLocacao(dto);
	}

	@GetMapping("/devolucao/{id}")
	private LocacaoDTO devolucaoLocacao(@PathVariable("id") Integer idLocacao) {
		return locacaoService.devolucaoLocacao(idLocacao);
	}
	
	@Override
	public DefaultCRUDService<LocacaoDTO, Locacao, Integer> getDefaultCRUDService() {
		return locacaoService;
	}

	@Override
	protected Validator[] getValidators() {
		return new Validator[] { locacaoValidator, renovacaoValidator };
	}
}