package kr.co.kalpa.sbtemplates.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.kalpa.sbtemplates.model.User;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {

	@GetMapping("/")
	public String main() {
		log.debug("****************************************");
		log.debug("Main...");
		log.debug("****************************************");
		return "main";
		
	}
	@PostMapping("/user")
	public String user(@ModelAttribute User user, Model model) {
		log.debug("user: {}",user);
		user.setBirth("20231203");
		
		return "main";
	}
}
