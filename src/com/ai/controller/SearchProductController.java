package com.ai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ai.persistant.dao.SearchProductDao;

@Controller
public class SearchProductController {
	
	
	@Autowired
	private SearchProductDao dao;
	
	@RequestMapping(value="/searchByCategoryId",method=RequestMethod.GET)
	public String searchByCategoryId(ModelMap m) {
		return null;
//		ArrayList<>
	}
}
