package br.com.beltramejp.api.validator;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import br.com.beltramejp.api.dto.LocacaoDTO;
import br.com.beltramejp.api.util.ValidatorRest;
import br.com.beltramejp.service.service.FilmeService;
import br.com.beltramejp.service.service.UsuarioService;

@Component
public class LocacaoValidator implements ValidatorRest{

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private FilmeService filmeService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return LocacaoDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		LocacaoDTO dto = (LocacaoDTO) target;
		
		if(dto.getUsuario() == null) {
			errors.rejectValue("usuario.idUsuario", CAMPO_OBRIGATORIO);
		}else if(dto.getUsuario().getIdUsuario() == null) {
			errors.rejectValue("usuario.idUsuario", CAMPO_OBRIGATORIO);
		}else if(usuarioService.countLocacaoByIdUsuario(dto.getUsuario().getIdUsuario()) >= UsuarioService.NUMERO_MAXIMO_LOCACAO) {
			errors.rejectValue("usuario", NUMERO_MAXIMO_LOCACOES);
		}
		
		if(dto.getFilme() == null) {
			errors.rejectValue("filme.idFilme", CAMPO_OBRIGATORIO);
		}else if(dto.getFilme().getIdFilme() == null){
			errors.rejectValue("filme.idFilme", CAMPO_OBRIGATORIO);
		}else {
			Object[] quantidadeLocacao = filmeService.findQuantidadeFilmeAndCountLocacaoByIdFilme(dto.getFilme().getIdFilme());
			
			if(quantidadeLocacao.length > 0) {
				if((Integer)quantidadeLocacao[0] <= (Integer) quantidadeLocacao[1]) {
					errors.rejectValue("filme.idFilme", FILME_INDISPONIVEL);
				}
			}
			
		}
		
		ValidationUtils.rejectIfEmpty(errors, "dataDevolucao", CAMPO_OBRIGATORIO);
		
		if(dto.getDataLocacao() == null) {
			dto.setDataLocacao(new Date());
		}
		
		dto.setTagDevolvido(false);
		dto.setRenovacao(0);
	}

}
