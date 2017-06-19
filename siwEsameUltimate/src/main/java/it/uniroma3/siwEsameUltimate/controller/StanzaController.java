package it.uniroma3.siwEsameUltimate.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siwEsameUltimate.model.Opera;
import it.uniroma3.siwEsameUltimate.model.Stanza;
import it.uniroma3.siwEsameUltimate.service.GalleriaService;
import it.uniroma3.siwEsameUltimate.service.OperaService;
import it.uniroma3.siwEsameUltimate.service.StanzaService;

@Controller
public class StanzaController {
	@Autowired
	private StanzaService stanzaService;
	@Autowired 
	private GalleriaService galleriaService;
	@Autowired
	private OperaService operaService;

	@GetMapping("/stanza")
	public String showForm(Model model){
		Long idStanza = null;
		model.addAttribute("stanze", stanzaService.findAll());
		model.addAttribute("idStanza",idStanza );
		return "stanza";
	}
	@PostMapping("/stanza")
	public String showContent(Model model,@RequestParam Long idStanza,HttpServletRequest request){
		List<Opera> opere=stanzaService.findbyId(idStanza).getOpereEsposte();
		Stanza stanza = stanzaService.findbyId(idStanza);
		model.addAttribute("opere", opere);
		request.setAttribute("idStanza", idStanza);
		model.addAttribute("stanza",stanza);
		return "stanzaContent";
		
	}
	
	@PostMapping("/admin/selezionaOpera")
	public String selezionaOpera(Model model,@RequestParam Long idStanza,HttpServletRequest request){
		List<Opera>opere=(List<Opera>) galleriaService.getOpereNonEsposte();
		model.addAttribute("opereNonEsposte", opere);
		request.setAttribute("idStanza",idStanza);
//		model.addAttribute("stanza",stanza);
		return "admininserimentoOperaStanza";
		
		
	}
	@PostMapping("/admin/aggiungiOpera")
	public String addOpera(Model model,@RequestParam Long idStanza,@RequestParam Long operaId, HttpServletRequest request){
		Opera opera= galleriaService.findOperaById(operaId);
		stanzaService.addOpera(idStanza,opera);
		Stanza stanza =stanzaService.findbyId(idStanza);
		operaService.posizionaInStanza(stanza,operaId);
		model.addAttribute(opera);
		model.addAttribute("stanza", stanza);
		
		return "adminInserimentoOpera";
	}
}
