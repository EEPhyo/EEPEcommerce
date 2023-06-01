package com.ai.controller;

import java.awt.print.Pageable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ai.model.Product;
import com.ai.persistant.dao.CategoryDao;
import com.ai.persistant.dao.ColorDao;
import com.ai.persistant.dao.ProductDao;
import com.ai.persistant.dao.SizeDao;
import com.ai.persistant.dto.CategoryDto;
import com.ai.persistant.dto.ColorDto;
import com.ai.persistant.dto.ProductDto;
import com.ai.persistant.dto.SizeDto;


@Controller
public class UserProductController {
	
	@Autowired
	private ProductDao dao;
	
	@Autowired
	private CategoryDao categorydao;
	
	@Autowired
	private ColorDao colordao;
	
	@Autowired
	private SizeDao sizedao;
	
	@RequestMapping(value = "/userProductList", method = RequestMethod.GET)
	public String userProductList(ModelMap m) throws IOException {
	   
			ArrayList<ProductDto> list= dao.selectAll();
		 	ArrayList<CategoryDto> categories= categorydao.selectAll();
	    	ArrayList<ColorDto> colors= colordao.selectAll();
	    	ArrayList<SizeDto> sizes = sizedao.selectAll();
			m.addAttribute("categories",categories);	
			m.addAttribute("colors",  colors);		
			m.addAttribute("sizes", sizes);
		    m.addAttribute("products", list);
		    return "/frontend/product1";
	}

	
	@RequestMapping(value = "/getProductByPage/{pageid}", method = RequestMethod.GET)
	public String displayView(@PathVariable int pageid,ModelMap m) throws IOException {
	   
		  int total=5;    
	        if(pageid==1){}    
        else{    
	            pageid=(pageid-1)*total+1;    
	        }    
	        
	        System.out.println(pageid);  
		
		
		
		 	List<ProductDto> list = dao.getProductByPage(pageid,total);
		 	ArrayList<CategoryDto> categories= categorydao.selectAll();
	    	ArrayList<ColorDto> colors= colordao.selectAll();
	    	ArrayList<SizeDto> sizes = sizedao.selectAll();
			m.addAttribute("categories",categories);	
			m.addAttribute("colors",  colors);		
			m.addAttribute("sizes", sizes);
		    m.addAttribute("products", list);
		    return "/frontend/product1";
	}

}
