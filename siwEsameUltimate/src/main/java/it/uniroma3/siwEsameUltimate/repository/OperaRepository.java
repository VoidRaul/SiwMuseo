package it.uniroma3.siwEsameUltimate.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siwEsameUltimate.model.Autore;
import it.uniroma3.siwEsameUltimate.model.Opera;
import it.uniroma3.siwEsameUltimate.model.Stanza;


public interface OperaRepository extends CrudRepository<Opera,Long>{
	List<Opera> findByTitolo(String titoloOpera);
	
}
