package com.ai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ai.persistant.dao.UserDao;

@Controller
public class UserController {
		@Autowired
		private UserDao UserDao;
		@RequestMapping(value="/home",method=RequestMethod.GET)
		public String home() {
			
			return "/frontend/home";
		}
	
}

