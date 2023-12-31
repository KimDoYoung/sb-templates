package kr.co.kalpa.sbtemplates.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
