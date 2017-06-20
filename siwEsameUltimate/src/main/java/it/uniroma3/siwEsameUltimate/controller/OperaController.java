package it.uniroma3.siwEsameUltimate.controller;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
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
import it.uniroma3.siwEsameUltimate.service.GalleriaService;
import it.uniroma3.siwEsameUltimate.service.OperaService;




@Controller
public class OperaController {
	@Autowired
	private GalleriaService galServ;
	@Autowired
	private OperaService operaservice;
	@Autowired
	private AutoreService autoreservice;
	private Iterable<Autore> autori = new ArrayList<>();
	
	
	
	@GetMapping("/opera")
	public String showAllOpera( Model model,HttpServletRequest request){
		String rootPath = System.getProperty("catalina.home");
		String dir = rootPath+"/tmpFiles/";
		
	
		// Create the file on serverString rootPath = "/home/raul/Documents/siwEsameUltimate/siwEsameUltimate/src/main/resources/img/";
		Iterable<Opera> opereEsposte = new ArrayList<>();
		Iterable<Opera> opereNonEsposte = new ArrayList<>();		
		opereEsposte=galServ.getOpereEsposte();
		opereNonEsposte=galServ.getOpereNonEsposte();
		model.addAttribute("serverFile",dir);
		model.addAttribute("opereEsposte",opereEsposte);
		model.addAttribute("opereNonEsposte",opereNonEsposte);
		return "showOpera";
		
	}
	@GetMapping("/admin/opera")
	public String showForm(@ModelAttribute Opera opera, Model model, 
					@ModelAttribute String idAutore){
		autori = autoreservice.findAll();
		model.addAttribute("autori", autori);
		return "adminoperaForm";
	}
	@PostMapping("/admin/opera")
	public String checkOperaInfo(@Valid @ModelAttribute Opera opera,@RequestParam String idAutore,
			BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()){
			autori = autoreservice.findAll();
			model.addAttribute("autori", autori);
			return "adminoperaForm";
		}
		else{
			model.addAttribute(opera);
			model.addAttribute("idAutore", idAutore);
			opera.setAutore(autoreservice.findbyId(Long.decode(idAutore)));
			operaservice.add(opera);
		}
		return "adminresults";
	}
}