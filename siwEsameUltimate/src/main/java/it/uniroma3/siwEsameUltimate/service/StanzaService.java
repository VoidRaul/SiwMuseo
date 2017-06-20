package it.uniroma3.siwEsameUltimate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siwEsameUltimate.model.Opera;
import it.uniroma3.siwEsameUltimate.model.Stanza;
import it.uniroma3.siwEsameUltimate.repository.StanzaRepository;

@Service
public class StanzaService {
	@Autowired
	private StanzaRepository stanzaRepo;

	public Iterable<Stanza> findAll(){
		return stanzaRepo.findAll();
	}
	@Transactional
	public void add(final Stanza stanza) {
		this.stanzaRepo.save(stanza);
	}

	public Stanza findbyId(Long id) {
		return this.stanzaRepo.findOne(id);
	}
	@Transactional
	public void addOpera(Long id,Opera opera){
		this.stanzaRepo.findOne(id).addOpera(opera);
	}
	@Transactional
	public void rimuoviOpera(Long idStanza, Opera Opera) {
		// TODO Auto-generated method stub
		List<Opera>opere=this.findbyId(idStanza).getOpereEsposte();
		opere.remove(opere.indexOf(Opera));
	}

	

}
