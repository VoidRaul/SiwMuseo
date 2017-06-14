package it.uniroma3.siwEsameUltimate.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siwEsameUltimate.model.Stanza;


public interface StanzaRepository extends CrudRepository<Stanza,Long>{
	List<Stanza> FindByNome(String nome);
}
