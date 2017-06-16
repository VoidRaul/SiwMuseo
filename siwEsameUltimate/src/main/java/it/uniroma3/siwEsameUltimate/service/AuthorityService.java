package it.uniroma3.siwEsameUltimate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siwEsameUltimate.model.Authority;
import it.uniroma3.siwEsameUltimate.model.Users;
import it.uniroma3.siwEsameUltimate.repository.AuthorityRepository;

@Service
public class AuthorityService {
	@Autowired
	private AuthorityRepository authorityRepository; 

	public Iterable<Authority> findAll() {
		return this.authorityRepository.findAll();
	}

	@Transactional
	public void add(final Authority authority) {
		this.authorityRepository.save(authority);
	}
	
	public Authority findbyId(Long id) {
		return this.authorityRepository.findOne(id);
	}

}
