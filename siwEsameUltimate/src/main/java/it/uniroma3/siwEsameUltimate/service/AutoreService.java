package it.uniroma3.siwEsameUltimate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siwEsameUltimate.model.Autore;
import it.uniroma3.siwEsameUltimate.repository.AutoreRepository;
import it.uniroma3.siwEsameUltimate.repository.GalleriaRepository;

@Service
public class AutoreService {
	@Autowired
	private GalleriaService galservice;
	@Autowired
	private AutoreRepository autoreRepository; 

	public Iterable<Autore> findAll() {
		return this.autoreRepository.findAll();
	}

	@Transactional
	public void add(final Autore autore) {
		this.galservice.addAutore(autore);
		this.autoreRepository.save(autore);
	}

	public Autore findbyId(Long id) {
		return this.autoreRepository.findOne(id);
	}

}
