package it.uniroma3.siwEsameUltimate.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private Long enabled;
	@ManyToOne
	@JoinColumn(name="authority")
	private Authority authority;
	
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
	
	public String getUsername() {
		return username;
	}
	public Authority getAuthority() {
		return authority;
	}
	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
	public Long getEnabled() {
		return enabled;
	}
	public void setEnabled(Long enabled) {
		this.enabled = enabled;
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
