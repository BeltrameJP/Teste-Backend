package br.com.beltramejp.api.util;

import org.springframework.validation.Validator;

public interface ValidatorRest extends Validator{

	static final String CAMPO_OBRIGATORIO = "Campo Obrigatório";
	
	static final String IDADE_18_ANOS = "Usuário com menos de 18 anos";
	
	static final String QUANTIDADE_MAIOR_0 = "Quantidade deve ser maior que 0";
	
	static final String NUMERO_MAXIMO_LOCACOES = "Número máximo de locações permitidas para essa entrada";
	
	static final String FILME_INDISPONIVEL = "Filme Indisponível para Locação";
	
	static final String NUMERO_MAXIMO_RENOVACAO = "Número máximo de renovações permitidas para essa entrada";
	
}
