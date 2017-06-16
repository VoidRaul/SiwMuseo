package it.uniroma3.siwEsameUltimate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Users {
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Long id;
	@Id
	@NotNull
	private String username;
	@NotNull
	private String password;
	
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String nome) {
		this.username = nome;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(6);
		String hashedPassword = passwordEncoder.encode(password);
		this.password = hashedPassword;
	}
	
	
}
