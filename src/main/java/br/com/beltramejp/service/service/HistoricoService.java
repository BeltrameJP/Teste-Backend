package br.com.beltramejp.service.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.beltramejp.api.dto.HistoricoDTO;
import br.com.beltramejp.api.dto.LocacaoDTO;
import br.com.beltramejp.api.dto.enumerator.EventoTipoEnum;
import br.com.beltramejp.domain.entity.Historico;
import br.com.beltramejp.domain.repository.HistoricoRepository;
import br.com.beltramejp.domain.util.CustomRepository;
import br.com.beltramejp.service.converter.HistoricoConverter;
import br.com.beltramejp.service.util.CustomConverter;
import br.com.beltramejp.service.util.DefaultCRUDService;

@Service
public class HistoricoService extends DefaultCRUDService<HistoricoDTO, Historico, Integer>{

	@Autowired
	private HistoricoConverter historicoConverter;

	@Autowired
	private HistoricoRepository historicoRepository;

	@Transactional
	public void saveAcaoLocacao(LocacaoDTO locacaoDTO, EventoTipoEnum e) {
		HistoricoDTO dto = new HistoricoDTO();
		
		dto.setUsuario(locacaoDTO.getUsuario());
		dto.setFilme(locacaoDTO.getFilme());
		dto.setDataEvento(new Date());
		dto.setEventoTipo(e);
		
		create(dto);
	}
	
	@Transactional
	public List<String> findHistoricoByIdFilme(Integer idFilme){
		return historicoToString(historicoRepository.findHistoricoByIdFilme(idFilme));
	}	
	
	@Transactional
	public List<String> findHistoricoByIdUsuario(Integer idUsuario){
		return historicoToString(historicoRepository.findHistoricoByIdFilme(idUsuario));
	}
	
	@Transactional
	public List<String> findAllString(){
		return historicoToString(getRepository().findAll());
	}
	
	private List<String> historicoToString(List<Historico> historicos){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		return historicos.parallelStream().map(e -> {
			StringBuilder builder = new StringBuilder();
			
			builder.append("Filme: "); 
			builder.append(e.getFilme().getNome());
			builder.append("\nUsuario: ");
			builder.append(e.getUsuario().getNome());
			builder.append("\nAção: ");
			builder.append(e.getEventoTipo().getDescricao());
			builder.append("\nData: ");
			builder.append(simpleDateFormat.format(new Date()));
			
			return builder.toString();
		}).collect(Collectors.toList()); 
	}
	
	@Override
	public CustomConverter<Historico, HistoricoDTO> getConverter() {
		return historicoConverter;
	}

	@Override
	public CustomRepository<Historico, Integer> getRepository() {
		return historicoRepository;
	}

}
