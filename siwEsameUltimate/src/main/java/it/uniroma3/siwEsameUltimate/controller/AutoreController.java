package it.uniroma3.siwEsameUltimate.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siwEsameUltimate.model.Autore;
import it.uniroma3.siwEsameUltimate.service.AutoreService;
import it.uniroma3.siwEsameUltimate.service.GalleriaService;
import it.uniroma3.siwEsameUltimate.validaor.AutoreValidator;

@Controller
public class AutoreController {

	@Autowired
	private AutoreService autoreservice;
	@Autowired
	private AutoreValidator autorVal;
	@Autowired
	private GalleriaService galService;
	@InitBinder
	protected void initBinder(final WebDataBinder binder) {
	    binder.addValidators(autorVal);
	}
	@GetMapping("/autore")
	public String showAutore(Model model){
		List<Autore> autori = (List<Autore>) galService.getAutori();
		model.addAttribute("autori",autori);
		return "showAutori";
	}
	
	@GetMapping("/admin/autore")
	public String showForm(Autore autore){
		return "adminautoreForm";
	}
	@PostMapping("/admin/autore")
	public String checkAutoreInfo(@Valid @ModelAttribute Autore autore,
			BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()){
			return "adminautoreForm";
		}
		else{
			model.addAttribute(autore);
			autoreservice.add(autore);
		}
		return "adminautoreResults";
	}
}
