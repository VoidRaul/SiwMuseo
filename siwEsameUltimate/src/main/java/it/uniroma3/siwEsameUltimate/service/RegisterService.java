package it.uniroma3.siwEsameUltimate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siwEsameUltimate.model.Users;
import it.uniroma3.siwEsameUltimate.repository.RegisterRepository;



@Service
public class RegisterService {
	@Autowired
	private RegisterRepository usersRepository; 

	public Iterable<Users> findAll() {
		return this.usersRepository.findAll();
	}

	@Transactional
	public void add(final Users users) {
		this.usersRepository.save(users);
	}
	public Users findByUsername(String username){
		List<Users>allUsers=(List<Users>) this.usersRepository.findAll();
		for(Users a :allUsers){
			if(a.getUsername().equals(username))
				return a;
		}
		return null;
	}
	public Users findbyId(Long id) {
		return this.usersRepository.findOne(id);
	}

}


