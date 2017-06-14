package it.uniroma3.siwEsameUltimate.model;

import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Galleria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nome;
	private List<Autore> autori;
	@OneToMany
	private Map<Long,Stanza> stanzaGalleria;	//long refer to the AutoGeneratedValue
	
	
	public void addStanza(Stanza stanza){
		this.stanzaGalleria.put(stanza.getId(), stanza);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Map<Long, Stanza> getStanzaGalleria() {
		return stanzaGalleria;
	}

	public void setStanzaGalleria(Map<Long, Stanza> stanzaGalleria) {
		this.stanzaGalleria = stanzaGalleria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nomeGalleria) {
		this.nome = nomeGalleria;
	}
	
	@Override
	public boolean equals(Object gal){
		return this.getNome().equals(gal.toString());
		
	}
	@Override
	public String toString(){
		return this.getNome();
	}

	public List<Autore> getAutori() {
		return autori;
	}

	public void setAutori(List<Autore> autori) {
		this.autori = autori;
	}
}
