package com.ai.controller;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class LogoutController {
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession request) {
		
		if(request != null) 
			request.removeAttribute("email");			
			request.removeAttribute("id");
			request.invalidate();			
			request.setAttribute("errMessage","You have logged out successfully");
		
			
	
		return "redirect:/auth/login";
	}
}
	
	

