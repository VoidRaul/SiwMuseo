package it.uniroma3.siwEsameUltimate.controller;

import java.util.ArrayList;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siwEsameUltimate.model.Autore;
import it.uniroma3.siwEsameUltimate.model.Opera;
import it.uniroma3.siwEsameUltimate.service.AutoreService;
import it.uniroma3.siwEsameUltimate.service.OperaService;




@Controller
public class OperaController {

	@Autowired
	private OperaService operaservice;
	@Autowired
	private AutoreService autoreservice;
	private Iterable<Autore> autori = new ArrayList<>();
	
	
	
	@GetMapping("/opera")
	public String showForm(@ModelAttribute Opera opera, Model model, 
					@ModelAttribute String idAutore){
		autori = autoreservice.findAll();
		model.addAttribute("autori", autori);
		return "operaForm";
	}
	@PostMapping("/opera")
	public String checkOperaInfo(@Valid @ModelAttribute Opera opera,@RequestParam String idAutore,
			BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()){
			autori = autoreservice.findAll();
			model.addAttribute("autori", autori);
			return "operaForm";
		}
		else{
			model.addAttribute(opera);
			model.addAttribute("idAutore", idAutore);
			opera.setAutore(autoreservice.findbyId(Long.decode(idAutore)));
			operaservice.add(opera);
		}
		return "results";
	}
}