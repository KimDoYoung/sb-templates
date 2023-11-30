package kr.co.kalpa.sbtemplates.controller;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.annotation.Resource;
import kr.co.kalpa.sbtemplates.SystemConfigVariables;
import kr.co.kalpa.sbtemplates.SystemPropertyVariables;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {

	@Autowired
	private SystemConfigVariables systemVariables;

	@Value("#{systemConfigProps['address']})")
	private String address;	
	
	@Resource(name = "systemConfigProps")
	private Properties prop;
	
	
	@GetMapping("/")
	public String main(Model model) {
		
		model.addAttribute("num", systemVariables.getNumVariable());
		model.addAttribute("str", systemVariables.getStrVariable());
		
		model.addAttribute("emails", systemVariables.getEmails());
		model.addAttribute("map", systemVariables.getMap());
		model.addAttribute("user", systemVariables.getUser());
		model.addAttribute("address", address);
		
		//log	.debug(prop.getProperty("address"));
		System.out.println(prop.getProperty("address"));
		
		
		return "main";
		
	}
}
