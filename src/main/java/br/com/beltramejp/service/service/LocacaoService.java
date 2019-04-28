package br.com.beltramejp.service.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.beltramejp.api.dto.LocacaoDTO;
import br.com.beltramejp.api.dto.RenovacaoDTO;
import br.com.beltramejp.api.dto.enumerator.EventoTipoEnum;
import br.com.beltramejp.domain.entity.Locacao;
import br.com.beltramejp.domain.repository.LocacaoRepository;
import br.com.beltramejp.domain.util.CustomRepository;
import br.com.beltramejp.service.converter.LocacaoConverter;
import br.com.beltramejp.service.util.CustomConverter;
import br.com.beltramejp.service.util.DefaultCRUDService;

@Service
public class LocacaoService extends DefaultCRUDService<LocacaoDTO, Locacao, Integer> {

	public static final Integer NUMERO_MAX_RENOVACAO = 2;
	
	@Autowired
	private LocacaoConverter locacaoConverter;

	@Autowired
	private LocacaoRepository locacaoRepository;
	
	@Autowired
	private HistoricoService historicoService;

	public LocacaoDTO renovacaoLocacao(RenovacaoDTO dto) {
		Locacao dao = locacaoRepository.getOne(dto.getIdLocacao());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dao.getDataDevolucao());
		calendar.add(Calendar.DAY_OF_MONTH, dto.getAdiamentoDias());
		
		dao.setDataDevolucao(calendar.getTime());
		
		LocacaoDTO locacaoDTO = update(getConverter().convertDAO(dao));
		
		historicoService.saveAcaoLocacao(locacaoDTO, EventoTipoEnum.RENOVACAO);
		
		return locacaoDTO;
	}
	
	@Transactional
	public LocacaoDTO devolucaoLocacao(Integer idLocacao) {
		Locacao dao = getRepository().getOne(idLocacao);
		
		dao.setTagDevolvido(true);
		getRepository().save(dao);
		
		LocacaoDTO dto = getConverter().convertDAO(dao);

		historicoService.saveAcaoLocacao(dto, EventoTipoEnum.DEVOLUCAO);
				
		return dto;
	}
	
	@Override
	public LocacaoDTO create(LocacaoDTO dto) {
		dto = super.create(dto);

		historicoService.saveAcaoLocacao(dto, EventoTipoEnum.RENOVACAO);
		
		return dto;
	}
	
	@Override
	public CustomConverter<Locacao, LocacaoDTO> getConverter() {
		return locacaoConverter;
	}

	@Override
	public CustomRepository<Locacao, Integer> getRepository() {
		return locacaoRepository;
	}
	

}
