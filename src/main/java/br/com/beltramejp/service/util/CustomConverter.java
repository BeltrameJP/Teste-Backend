package br.com.beltramejp.service.util;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

public abstract class CustomConverter<DAO, DTO> extends CustomMapper<DAO, DTO> {

	public abstract DAO convertDTO(DTO entity);

	public abstract DTO convertDAO(DAO entity);

	@Override
	public void mapAtoB(DAO a, DTO b, MappingContext context) {
		b = convertDAO(a);
	}

	@Override
	public void mapBtoA(DTO b, DAO a, MappingContext context) {
		a = convertDTO(b);
	}
	
}
