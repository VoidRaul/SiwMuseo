package it.uniroma3.siwEsameUltimate.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siwEsameUltimate.model.Opera;
import it.uniroma3.siwEsameUltimate.service.OperaService;




@Controller
public class OperaController {

	@Autowired
	private OperaService operaservice;
	
	@GetMapping("/opera")
	public String showForm(Opera opera){
		return "operaForm";
	}
	@PostMapping("/opera")
	public String checkOperaInfo(@Valid @ModelAttribute Opera opera,
			BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()){
			return "operaForm";
		}
		else{
			model.addAttribute(opera);
			operaservice.add(opera);
		}
		return "results";
	}
}