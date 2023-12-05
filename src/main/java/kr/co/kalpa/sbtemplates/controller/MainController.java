package kr.co.kalpa.sbtemplates.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import kr.co.kalpa.sbtemplates.model.User;
import kr.co.kalpa.sbtemplates.view.JsonView;

@Controller
public class MainController {

	@GetMapping("/")
	public String main() {
		return "main";
	}
	List<User> users =  new ArrayList<User>( Arrays.asList(
			new User("1","Hong"),new User("2","Gil"),new User("3","Dong")
			));
	@ResponseBody
	@GetMapping("ajax2")
	public String ajax2() {
		
//		List<User> users = new ArrayList<User>();
//		users.add(new User("1","Hong"));
//		users.add(new User("2","Gil"));
//		users.add(new User("3","Dong"));
		Gson gson = new Gson(); 
		String json = gson.toJson(users); 
		return json;
	}	
	
	@PostMapping("ajax3")
	public ModelAndView ajax3(@RequestBody User user) {
		
//		List<User> users = new ArrayList<User>();
//		users.add(new User("1","Hong"));
//		users.add(new User("2","Gil"));
//		users.add(new User("3","Dong"));
		users.add(new User(user.getId(), user.getName()));
		
		ModelAndView mav = new ModelAndView(new JsonView());
		mav.addObject("list", users);
		return mav;
	}	
}
