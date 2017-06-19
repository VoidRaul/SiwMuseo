package it.uniroma3.siwEsameUltimate.model;

import java.util.List;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Authority {

	//	
	//	@GeneratedValue(strategy=GenerationType.AUTO)
	//	private Long id;
	@Id
	private String authority;
	@OneToMany
	private List<Users> user;

	public List<Users> getUser() {
		return user;
	}



	public void setUser(List<Users> user) {
		this.user = user;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
//rimosse
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}


}
