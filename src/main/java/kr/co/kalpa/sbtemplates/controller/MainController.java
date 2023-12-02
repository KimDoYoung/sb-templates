package kr.co.kalpa.sbtemplates.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import kr.co.kalpa.sbtemplates.exception.AssetException;
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
	
	@GetMapping("/exception1")
	public String notControlledException() {
		Integer.parseInt("a");
		return null;
	}
	@GetMapping("/exception2")
	public String ControlledException() {
		
		throw new AssetException("Asset Exception...");
		
	}
	@GetMapping("exception-ajax1")
	public String Ajax() {
		
		throw new AssetException("Asset Exception...");
		
	}
}
