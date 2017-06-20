package it.uniroma3.siwEsameUltimate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siwEsameUltimate.model.Autore;
import it.uniroma3.siwEsameUltimate.model.Opera;
import it.uniroma3.siwEsameUltimate.model.Stanza;
import it.uniroma3.siwEsameUltimate.repository.GalleriaRepository;

@Service
public class GalleriaService {
	@Autowired
	private GalleriaRepository gallrepo;
	
	public void addAutore(Autore a){
		List<Autore> autori = (List<Autore>) this.getAutori();
		autori.add(a);
	}
	public Iterable<Autore> getAutori(){
		return this.gallrepo.findOne((long)1).getAutori();
	}
	public Opera findOperaById(Long id){
		for(Opera a : this.getOpere()){
			if (a.getId()==id)
				return a;
		}
		return null;
	}
	public Stanza findStanzaById(Long id){
		for(Stanza a : this.getStanze()){
			if (a.getId()==id)
				return a;
		}
		return null;
	}
	private Iterable<Stanza> getStanze() {
		return gallrepo.findOne((long)1).getStanzaGalleria();
	}
	public Iterable<Opera> getOpere(){
	return gallrepo.findOne((long)1).getOpereGalleria();
	
	}
	public Iterable<Opera> getOpereNonEsposte(){
		List<Opera> opereGalleria = new ArrayList<Opera>();
		for(Opera o : this.getOpere()){
			if (o.getStanza()==null){
				opereGalleria.add(o);
			}
		}
		return opereGalleria;
	}
	public Iterable<Opera> getOpereEsposte(){
		List<Opera> opereGalleria = new ArrayList<Opera>();
		for(Opera o : this.getOpere()){
			if (o.getStanza()!=null){
				opereGalleria.add(o);
			}
		}
		return opereGalleria;
	}
	public void addOpera(Opera opera) {
		List <Opera> opere =(List<Opera>) this.getOpere();
		opere.add(opera);
		
	}
}
