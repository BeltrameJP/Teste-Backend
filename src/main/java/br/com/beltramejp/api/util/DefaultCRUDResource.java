package br.com.beltramejp.api.util;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.beltramejp.domain.util.Identifiable;
import br.com.beltramejp.service.util.DefaultCRUDService;

public abstract class DefaultCRUDResource<DTO extends Serializable, DAO extends Identifiable, ID extends Number> {
	
	protected SimpleDateFormat dateFormat = new SimpleDateFormat(getTimeMask());
	
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		
		if(binder.getTarget() != null) {
			for(Validator val : getValidators()) {
				if(val.supports(binder.getTarget().getClass())) {
					binder.setValidator(val);
				}
			}
		}
		
	}
	
	@PostMapping("/create")
	public DTO create(@RequestBody @Valid DTO DTO){
		return getDefaultCRUDService().create(DTO);
	}
	
	@GetMapping("/{id}")
	public DTO get(@PathVariable("id") ID id) {
		try {
			return getDefaultCRUDService().get(id);
		} catch (EntityNotFoundException e) {
			throw e;
		}
	}
	
	@GetMapping("/")
	public List<DTO> findAll() {
		return getDefaultCRUDService().findAll();
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") ID id){
		try {
			getDefaultCRUDService().delete(id);
			return new ResponseEntity<String>(HttpStatus.ACCEPTED);
		}catch (IllegalArgumentException e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
  	}
	
	@PutMapping("/update")
	public DTO update(@RequestBody @Valid DTO DTO){
		return getDefaultCRUDService().update(DTO);
	}
	
	protected abstract DefaultCRUDService<DTO, DAO, ID> getDefaultCRUDService();
	
	protected Validator[] getValidators() {
		return new Validator[] {};
	};
	
	protected String getTimeMask() {
		return "dd/MM/yyyy HH:mm:ss";
	}
}
