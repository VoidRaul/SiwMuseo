package it.uniroma3.siwEsameUltimate.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siwEsameUltimate.model.Users;
import it.uniroma3.siwEsameUltimate.service.RegisterService;



@Controller
public class RegisterController {
	@Autowired
	private RegisterService registerservice;
	
	@GetMapping("/register")
	public String showForm(Users user){
		return "register";
	}
	@PostMapping("/register")
	public String checkUsersInfo(@Valid @ModelAttribute Users users,
			BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()){
			return "register";
		}
		else{
			model.addAttribute(users);
			registerservice.add(users);
		}
		return "index";
	}
}
