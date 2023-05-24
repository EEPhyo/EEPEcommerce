package com.ai.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ai.persistant.dao.CategoryDao;
import com.ai.persistant.dto.CategoryDto;

@Controller
public class CategoryController {
	 @Autowired
     private CategoryDao CategoryDao;
     @RequestMapping(value="/home",method=RequestMethod.GET)
	public String home() {
		return "/frontend/home";
	}
}
