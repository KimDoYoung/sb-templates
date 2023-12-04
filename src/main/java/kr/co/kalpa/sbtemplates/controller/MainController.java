package kr.co.kalpa.sbtemplates.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.validation.Valid;
import kr.co.kalpa.sbtemplates.model.User;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {

	@GetMapping("/")
	public String main() {
		log.debug("로그테스트....");
		return "main";
		
	}
	@GetMapping("/user")
	public String user(@Valid @ModelAttribute User user, BindingResult bindResult) {
		if(bindResult.hasErrors()) {
			List<FieldError> list = bindResult.getFieldErrors();
			for (FieldError err : list) {
				log.error(err.getDefaultMessage());
			}
			
		}
		log.debug("로그테스트....");
		return "main";
		
	}
}
