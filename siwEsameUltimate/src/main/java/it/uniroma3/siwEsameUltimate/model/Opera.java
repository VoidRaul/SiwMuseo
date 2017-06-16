package it.uniroma3.siwEsameUltimate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
public class Opera {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotNull
	@Pattern(regexp="\\d{4}")
	private String anno;
	@NotNull
	private String titolo;
	@ManyToOne
	private Autore autore;
	@ManyToOne
	private Stanza stanza;
	
	public Stanza getStanza() {
		return stanza;
	}
	public void setStanza(Stanza stanza) {
		this.stanza = stanza;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAnno() {
		return anno;
	}
	public void setAnno(String anno) {
		this.anno = anno;
	}
	public Autore getAutore(){
		return this.autore;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public void setAutore(Autore autore) {
		this.autore = autore;
	}
	
	
}
