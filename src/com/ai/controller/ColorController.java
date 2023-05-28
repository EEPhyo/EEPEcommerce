package com.ai.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.ai.persistant.dao.ColorDao;
import com.ai.persistant.dto.ColorDto;


@Controller
public class ColorController {
	@Autowired
    private ColorDao dao;
	
}
