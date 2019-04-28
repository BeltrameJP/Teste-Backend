package br.com.beltramejp.api.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import br.com.beltramejp.api.dto.FilmeDTO;
import br.com.beltramejp.api.util.ValidatorRest;

@Component
public class FilmeValidator implements ValidatorRest{

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(FilmeDTO.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		FilmeDTO dto = (FilmeDTO) target;
		
		ValidationUtils.rejectIfEmpty(errors, "nome", CAMPO_OBRIGATORIO);
		ValidationUtils.rejectIfEmpty(errors, "diretor", CAMPO_OBRIGATORIO);
		ValidationUtils.rejectIfEmpty(errors, "quantidade", CAMPO_OBRIGATORIO);
		ValidationUtils.rejectIfEmpty(errors, "genero", CAMPO_OBRIGATORIO);
	
		if(dto.getQuantidade() != null && dto.getQuantidade() == 0) {
			errors.rejectValue("quantidade", QUANTIDADE_MAIOR_0);
		}
	}

}
