package it.uniroma3.siwEsameUltimate.validaor;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siwEsameUltimate.model.Users;
import it.uniroma3.siwEsameUltimate.service.RegisterService;

@Component
public class UserValidator implements Validator{

	@Autowired
	private RegisterService userService;
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Users.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		Users user = (Users) arg0;
		if (userService.findByUsername(user.getUsername())!= null) {
			arg1.rejectValue("login", "NonUniq.user");
		}

	}
}
