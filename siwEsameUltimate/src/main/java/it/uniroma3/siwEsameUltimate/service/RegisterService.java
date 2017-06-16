package it.uniroma3.siwEsameUltimate.service;

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
	public void add(Users users) {
		String password = users.getPassword();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		users.setPassword(hashedPassword);
		this.usersRepository.save(users);
	}

	public Users findbyId(Long id) {
		return this.usersRepository.findOne(id);
	}

}


