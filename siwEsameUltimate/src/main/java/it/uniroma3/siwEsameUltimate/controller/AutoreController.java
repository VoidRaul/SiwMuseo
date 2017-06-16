package it.uniroma3.siwEsameUltimate.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siwEsameUltimate.model.Autore;
import it.uniroma3.siwEsameUltimate.service.AutoreService;

@Controller
public class AutoreController {

	@Autowired
	private AutoreService autoreservice;
	
	@GetMapping("/autore")
	public String showForm(Autore autore){
		return "autoreForm";
	}
	@PostMapping("/autore")
	public String checkAutoreInfo(@Valid @ModelAttribute Autore autore,
			BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()){
			return "autoreForm";
		}
		else{
			model.addAttribute(autore);
			autoreservice.add(autore);
		}
		return "autoreResults";
	}
}
