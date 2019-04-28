package br.com.beltramejp.domain.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.beltramejp.api.dto.enumerator.EventoTipoEnum;

@Converter
public class EventoTipoConverter implements AttributeConverter<EventoTipoEnum, Integer> {

	@Override
	public Integer convertToDatabaseColumn(EventoTipoEnum attribute) {
		return attribute.getCodigo();
	}

	@Override
	public EventoTipoEnum convertToEntityAttribute(Integer dbData) {
		return EventoTipoEnum.getEnumByCodigo(dbData);
	}

}
