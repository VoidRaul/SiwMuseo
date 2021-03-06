package it.uniroma3.siwEsameUltimate.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("session")
@Entity
public class Autore {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	@NotNull
	private String nome,cognome;
	@NotNull
	private String nazionalita;
	@NotNull
	@Pattern(regexp="\\d{2}/\\d{2}/\\d{4}")
	private String dataNascita;
	@Pattern(regexp="\\d{2}/\\d{2}/\\d{4}")
	private String dataMorte;
	@OneToMany
	private List<Opera> opereRealizzate;
	@Column(name="Biography", length=1500)
	private String biography;
	
	
	
	
	
	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

	public void addOpera(Opera opera){
		this.opereRealizzate.add(opera);
	}
	
	public Long getId() {
		return Id;
	}
	
	public void setId(Long id) {
		Id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDataNascita() {
		return dataNascita;
	}
	
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}
	
	public String getDataMorte() {
		return dataMorte;
	}
	
	public void setDataMorte(String dataMorte) {
		this.dataMorte = dataMorte;
	}
	
	public List<Opera> getOpereRealizzate() {
		return opereRealizzate;
	}
	
	public void setOpereRealizzate(List<Opera> opereRealizzate) {
		this.opereRealizzate = opereRealizzate;
	}
}