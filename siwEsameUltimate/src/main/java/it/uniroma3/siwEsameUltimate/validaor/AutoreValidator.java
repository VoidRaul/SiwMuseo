package it.uniroma3.siwEsameUltimate.validaor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siwEsameUltimate.model.Autore;
import it.uniroma3.siwEsameUltimate.service.GalleriaService;

@Component
public class AutoreValidator implements Validator{

	@Autowired
	private GalleriaService gallServ;
	@Override
	public boolean supports(Class<?> autore) {
		// TODO Auto-generated method stub
		return Autore.class.equals(autore);
	}

	@Override
	public void validate(Object object, Errors arg1) {
		// TODO Auto-generated method stub
		Autore autore = (Autore) object;
		List<Autore>autori=(List<Autore>) gallServ.getAutori();
		
		if(autori.isEmpty())
			return;
		for(Autore a : autori){
			if(a.getNome().equals(autore.getNome()) && a.getCognome().equals(autore.getCognome()) && a.getNazionalita().equals(autore.getNazionalita())){
				arg1.rejectValue("autor", "NonUniq.user");
			}
		}

	}
}
