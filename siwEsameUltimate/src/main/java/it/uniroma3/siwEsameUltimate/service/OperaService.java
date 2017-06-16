package it.uniroma3.siwEsameUltimate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siwEsameUltimate.model.Autore;
import it.uniroma3.siwEsameUltimate.model.Opera;
import it.uniroma3.siwEsameUltimate.repository.OperaRepository;

@Service
public class OperaService {
	@Autowired
	private OperaRepository operaRepository;
	@Autowired 
	private AutoreService autoreservice;

	public Iterable<Opera> findAll() {
		return this.operaRepository.findAll();
	}

	@Transactional
	public void add(final Opera opera) {
		Autore autore = this.autoreservice.findbyId(opera.getAutore().getId());
		autore.addOpera(opera);
		this.operaRepository.save(opera);
	}

	public Opera findbyId(Long id) {
		return this.operaRepository.findOne(id);
	}

}
