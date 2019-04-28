package br.com.beltramejp.api.validator;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import br.com.beltramejp.api.dto.UsuarioDTO;
import br.com.beltramejp.api.util.ValidatorRest;

@Component
public class UsuarioValidator implements ValidatorRest{

	private final long dezoitoAnos = 567993600000L;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(UsuarioDTO.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UsuarioDTO dto = (UsuarioDTO) target;
		
		ValidationUtils.rejectIfEmpty(errors, "nome", CAMPO_OBRIGATORIO);
		ValidationUtils.rejectIfEmpty(errors, "cpf", CAMPO_OBRIGATORIO);
		
		if(dto.getDataNascimento() == null) {
			errors.rejectValue("Data de Nascimento", CAMPO_OBRIGATORIO);
		}else if(new Date().getTime() - dto.getDataNascimento().getTime() < dezoitoAnos) {
			errors.rejectValue("Data de Nascimento", IDADE_18_ANOS);
		}
		
		
	}

}
