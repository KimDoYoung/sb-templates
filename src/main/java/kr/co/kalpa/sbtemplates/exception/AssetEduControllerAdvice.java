package kr.co.kalpa.sbtemplates.exception;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.kalpa.sbtemplates.view.JsonView;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class AssetEduControllerAdvice  {
	
	 private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");

	 
	@ExceptionHandler(AssetEduException.class)
    public ModelAndView assetEduException1(AssetEduException e, HttpServletRequest request) {
		log.debug("************************************************");
		log.debug("ControllerAdvice...");
		log.debug("************************************************");
		ModelAndView mav = new ModelAndView("/error");
        mav.addObject("msg", e.getMessage() );
        mav.addObject("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        mav.addObject("timestamp", new Date());
//        mav.addObject("timestamp", ( System.currentTimeMillis()));
        mav.addObject("error", e.getMessage());
        mav.addObject("path", request.getRequestURL().toString());
        return mav;
    }
	@ExceptionHandler(AssetEduJsonException.class)
    public ModelAndView assetEduException2(AssetEduJsonException e, HttpServletRequest request) {
		log.debug("************************************************");
		log.debug("ControllerAdvice JSON.");
		log.debug("************************************************");
        
		ModelAndView mav = new ModelAndView(new JsonView());
        mav.addObject("msg", e.getMessage() );
        mav.addObject("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        mav.addObject("timestamp", sdf.format( System.currentTimeMillis()));
        mav.addObject("error", e.getMessage());
        mav.addObject("path", request.getRequestURL().toString());
        return mav;
    }	
}
