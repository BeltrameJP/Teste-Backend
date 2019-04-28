package br.com.beltramejp.api.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import br.com.beltramejp.api.dto.LocacaoDTO;
import br.com.beltramejp.api.dto.RenovacaoDTO;
import br.com.beltramejp.api.util.ValidatorRest;
import br.com.beltramejp.service.service.LocacaoService;

@Component
public class RenovacaoValidator implements ValidatorRest{

	@Autowired
	private LocacaoService locacaoService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(RenovacaoDTO.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "idLocacao", CAMPO_OBRIGATORIO);
		ValidationUtils.rejectIfEmpty(errors, "adiamentoDias", CAMPO_OBRIGATORIO);
		
		RenovacaoDTO dto = (RenovacaoDTO) target;
		
		if(dto.getIdLocacao() != null) {
			LocacaoDTO locacaoDTO = locacaoService.get(dto.getIdLocacao());
			if(locacaoDTO.getRenovacao() >= LocacaoService.NUMERO_MAX_RENOVACAO) {
				errors.rejectValue("idLocacal", NUMERO_MAXIMO_RENOVACAO);
			}
		}
		
	}

}
