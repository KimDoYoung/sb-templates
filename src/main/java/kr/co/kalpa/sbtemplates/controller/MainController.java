package kr.co.kalpa.sbtemplates.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.kalpa.sbtemplates.exception.AssetEduException;
import kr.co.kalpa.sbtemplates.exception.AssetEduJsonException;

@Controller
public class MainController {

	@GetMapping("/")
	public String main() {
		return "main";
	}
	
	@GetMapping("/exception")
	public String exception() throws Exception {
		throw new Exception();
	}
	@GetMapping("/assetedu/exception")
	public String asseteduexception() throws Exception {
		throw new AssetEduException("IT금융교육 Exception");
	}
	@GetMapping("/assetedu/exception-json")
	public String asseteduexceptionjson() throws Exception {
		throw new AssetEduJsonException("IT금융교육 Exception in json");
	}
	
	@GetMapping("/assetedu/exception-duplication-json")
	public String asseteduexceptionjson1() throws Exception {
		throw new AssetEduJsonException("이미 존재하는 데이터입니다. - duplication in json");
	}
}
