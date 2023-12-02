package kr.co.kalpa.sbtemplates.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import kr.co.kalpa.sbtemplates.exception.AssetException;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CustomErrorController extends AbstractErrorController {

	@Value("${server.error.path:${error.path:/error}}")
	private String ERROR_PATH;
	
	public CustomErrorController(ErrorAttributes errorAttributes) {
		super(errorAttributes);
	}
	private boolean isAjax(HttpServletRequest request) {
	    String requestedWithHeader = request.getHeader("X-Requested-With");
	    return "XMLHttpRequest".equals(requestedWithHeader);
	}
	@RequestMapping("/error")
	public ModelAndView error(HttpServletRequest request, Model model) {
		
		ModelAndView mav = null ;
		if(isAjax(request)) {
			System.out.println("이것은 ajax request...................");
			mav = new ModelAndView(new kr.co.kalpa.sbtemplates.view.JsonView());
		}else {
			mav = new ModelAndView("/error");
		}
		
		String msg = null;
		Exception e = (Exception) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
		if(e != null && e.getCause() instanceof AssetException) {
			msg = e.getMessage();
			msg = msg.substring(msg.lastIndexOf(":")+1);
		}
			
        ErrorAttributeOptions options = ErrorAttributeOptions
        	    .defaults()
        	    .including(ErrorAttributeOptions.Include.STACK_TRACE)
        	;
        Map<String, Object> errorAttributes = getErrorAttributes(request, options);
        log.debug("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");
		errorAttributes.forEach((attribute, value) -> {			
			log.debug("attribute : {}, value:{}", attribute, value);
		});
//		model.addAttribute("timestamp", errorAttributes.get("timestamp"));
//		model.addAttribute("status", errorAttributes.get("status"));
//		model.addAttribute("error", errorAttributes.get("error"));
//		model.addAttribute("path", errorAttributes.get("path"));
//		model.addAttribute("trace", errorAttributes.get("trace"));
//		model.addAttribute("msg", msg);
		mav.addObject("timestamp", errorAttributes.get("timestamp"));
		mav.addObject("status", errorAttributes.get("status"));
		mav.addObject("error", errorAttributes.get("error"));
		mav.addObject("path", errorAttributes.get("path"));
		mav.addObject("trace", errorAttributes.get("trace"));
		mav.addObject("msg", msg);
		log.debug("★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★");

        
		return mav;
		
	}

	
}
