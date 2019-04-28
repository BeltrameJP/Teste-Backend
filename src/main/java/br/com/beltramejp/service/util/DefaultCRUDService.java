package br.com.beltramejp.service.util;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;

import br.com.beltramejp.domain.util.CustomRepository;
import br.com.beltramejp.domain.util.Identifiable;

public abstract class DefaultCRUDService<DTO extends Serializable, DAO extends Identifiable, ID extends Number> {
	
	@SuppressWarnings("unchecked")
	@Transactional
	public DTO create(DTO dto){
		DAO dao = getRepository().save(getConverter().convertDTO(dto));
		
		dao = getRepository().getOne((ID) dao.getId());
		
		return getConverter().convertDAO(dao);
	}

	@Transactional
	public DTO get(ID id) {
		return getConverter().convertDAO(getRepository().getOne(id));
	}

	@Transactional
	public List<DTO> findAll() {
		return getRepository().findAll().stream().map(e -> getConverter().convertDAO(e)).collect(Collectors.toList());
	}
	
	@Transactional
	public void delete(ID id){
		getRepository().deleteById(id);
  	}

	@Transactional
	public DTO update(DTO dto){
		return getConverter().convertDAO(getRepository().save(getConverter().convertDTO(dto)));
	}
	
	
	public abstract CustomConverter<DAO, DTO> getConverter();

	public abstract CustomRepository<DAO, ID> getRepository();
	
}
