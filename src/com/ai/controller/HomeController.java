package com.ai.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ai.model.User;
import com.ai.persistant.dao.RoleDao;
import com.ai.persistant.dao.UserDao;
import com.ai.persistant.dto.RoleDto;
import com.ai.persistant.dto.UserDto;

@Controller
public class HomeController {
	
	@Autowired
	private UserDao dao;
	
	@Autowired
	private RoleDao role;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String displayView(ModelMap m) {
		ArrayList<UserDto> list = dao.selectAll();
		m.addAttribute("list",list);
		
		ArrayList<RoleDto> list1=role.selectRole();
		m.addAttribute("role",list1);
		
		return "dashboard";
	}
}
