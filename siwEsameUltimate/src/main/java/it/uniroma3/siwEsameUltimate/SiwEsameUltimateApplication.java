package it.uniroma3.siwEsameUltimate;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SiwEsameUltimateApplication {
//	@Autowired 
//	private AuthorityService autServ;
//	@Autowired
//	private RegisterService regSer;
//	
	
	public static void main(String[] args) {
		SpringApplication.run(SiwEsameUltimateApplication.class, args);
	}
}
//	public void initialize(){
//		List<Authority> au=(List<Authority>) autServ.findAll();
//		if(au.isEmpty()){
//			Authority authority = new Authority();
//			Users users = new Users();
//			List<Users>utenti=new ArrayList<Users>();
//			authority.setAuthority("ADMIN");
//			users.setUsername("admin");
//			users.setPassword("admin");
//			utenti.add(users);
//			authority.setUser(utenti);
//			autServ.add(authority);
//			regSer.add(users);
//			return;
//		}
//		else return;
//	}
