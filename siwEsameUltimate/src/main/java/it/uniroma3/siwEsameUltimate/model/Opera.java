package it.uniroma3.siwEsameUltimate.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


@Entity
public class Opera {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotNull
	private Date anno;
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
	public Date getAnno() {
		return anno;
	}
	public void setAnno(Date anno) {
		this.anno = anno;
	}
	public Autore getArtista(){
		return this.autore;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public void setArtista(Autore artista) {
		this.autore = artista;
	}
	
	
}
