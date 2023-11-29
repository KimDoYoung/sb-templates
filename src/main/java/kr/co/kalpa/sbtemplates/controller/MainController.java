package kr.co.kalpa.sbtemplates.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.kalpa.sbtemplates.SystemConfigVariables;

@Controller
public class MainController {

	@Autowired
	private SystemConfigVariables systemVariables;
	
	@GetMapping("/")
	public String main(Model model) {
		
		model.addAttribute("num", systemVariables.getNumVariable());
		model.addAttribute("str", systemVariables.getStrVariable());
		
		model.addAttribute("emails", systemVariables.getEmails());
		model.addAttribute("map", systemVariables.getMap());
		model.addAttribute("user", systemVariables.getUser());
		
		return "main";
		
	}
}
