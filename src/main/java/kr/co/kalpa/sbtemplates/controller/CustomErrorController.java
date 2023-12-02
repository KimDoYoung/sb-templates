package kr.co.kalpa.sbtemplates.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import kr.co.kalpa.sbtemplates.exception.AssetException;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CustomErrorController extends AbstractErrorController {

	//private final ErrorAttributes errorAttributes;
	@Value("${server.error.path:${error.path:/error}}")
	private String ERROR_PATH;
	

	
	public CustomErrorController(ErrorAttributes errorAttributes) {
		super(errorAttributes);
		//this.errorAttributes = errorAttributes;
	}
	private boolean isAjax(HttpServletRequest request) {
	    String requestedWithHeader = request.getHeader("X-Requested-With");
	    return "XMLHttpRequest".equals(requestedWithHeader);
	}
	//@RequestMapping(produces = MediaType.TEXT_HTML_VALUE)
	@RequestMapping("/error")
	public String error(HttpServletRequest request, Model model) {
		
		if(isAjax(request)) {
			System.out.println("이것은 ajax request...................");
		}
		
		String msg = null;
		Exception e = (Exception) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
		if(e != null && e.getCause() instanceof AssetException) {
			msg = e.getMessage();
			msg = msg.substring(msg.lastIndexOf(":")+1);
		}
			
        //ServletWebRequest servletWebRequest = new ServletWebRequest(request);
        ErrorAttributeOptions options = ErrorAttributeOptions
        	    .defaults()
        	    .including(ErrorAttributeOptions.Include.STACK_TRACE)
        	;
        Map<String, Object> errorAttributes = getErrorAttributes(request, options);
        log.debug("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		errorAttributes.forEach((attribute, value) -> {			
			log.debug("attribute : {}, value:{}", attribute, value);
		});
		model.addAttribute("timestamp", errorAttributes.get("timestamp"));
		model.addAttribute("status", errorAttributes.get("status"));
		model.addAttribute("error", errorAttributes.get("error"));
		model.addAttribute("path", errorAttributes.get("path"));
		model.addAttribute("trace", errorAttributes.get("trace"));
		model.addAttribute("msg", msg);
		log.debug("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");

        
		return "error";
		
	}

	
}
