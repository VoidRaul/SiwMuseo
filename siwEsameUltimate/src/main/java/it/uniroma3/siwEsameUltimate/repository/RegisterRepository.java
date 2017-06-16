package it.uniroma3.siwEsameUltimate.repository;

import org.springframework.data.repository.CrudRepository;
import it.uniroma3.siwEsameUltimate.model.Users;

public interface RegisterRepository extends CrudRepository<Users,Long> {

}
