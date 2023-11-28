package kr.co.kalpa.sbtemplates.controller;

import java.text.SimpleDateFormat;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.kalpa.sbtemplates.exception.AssetEduDuplicationJsonException;
import kr.co.kalpa.sbtemplates.exception.AssetEduException;
import kr.co.kalpa.sbtemplates.exception.AssetEduJsonException;
import kr.co.kalpa.sbtemplates.view.JsonView;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {

	@ExceptionHandler(AssetEduDuplicationJsonException.class)
    public ModelAndView duplicationData(AssetEduDuplicationJsonException e, HttpServletRequest request) {
		log.debug("************************************************");
		log.debug("ControllerAdvice JSON.");
		log.debug("************************************************");
		 final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
		ModelAndView mav = new ModelAndView(new JsonView());
        mav.addObject("msg", e.getMessage() );
        mav.addObject("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        mav.addObject("timestamp", sdf.format( System.currentTimeMillis()));
        mav.addObject("error", e.getMessage());
        mav.addObject("path", request.getRequestURL().toString());
        return mav;
    }	
	
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

	@GetMapping("/assetedu/define-exception-in-method")
	public String asseteduexceptionjson2() throws Exception {
		
		//throw new Exception("controller의 method 즉 특정 path에 특정 exception을 기술");
		try {
			
			Integer.parseInt("a");
			return null;
			
		} catch (Exception e) {
			throw new AssetEduJsonException(e.getMessage());
		}
	}
	@GetMapping("/assetedu/define-exception-in-controller")
	public String asseteduexceptionjson3() throws Exception {
		
		throw new AssetEduDuplicationJsonException("controller의 안에 exception을 기술");
	}
	
}
