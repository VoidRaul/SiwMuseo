package it.uniroma3.siwEsameUltimate.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siwEsameUltimate.model.Autore;


public interface AutoreRepository extends CrudRepository<Autore,Long> {
	List<Autore> findByNome(String nomeArtista);

}