package com.ai.controller;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ai.model.Category;
import com.ai.model.User;
import com.ai.persistant.dao.CategoryDao;
import com.ai.persistant.dto.CategoryDto;

@Controller
public class CategoryController {
	 @Autowired
     private CategoryDao dao;
	 
     @RequestMapping(value="/category",method=RequestMethod.GET)
     public String displayView(ModelMap m) {
 		ArrayList<CategoryDto> list = dao.selectAll();
 		m.addAttribute("list",list);		
 		return "/categories/index";
 		
 	}
     
     
    @RequestMapping(value="/setupaddCategory",method=RequestMethod.GET)
 	public ModelAndView setupaddbook() {
 		return new ModelAndView("categories/create","bean",new Category());		
 		
 	} 	
     
     @RequestMapping(value="/create" ,method=RequestMethod.POST)
     public String addCategory(@ModelAttribute("bean") @Validated Category category, BindingResult result, ModelMap model) {
		
    	 if(result.hasErrors()) {
 			model.addAttribute("error","Invalid Category required");
 			return "/categories/create";
 		}
    	 
    	 CategoryDto dto = new CategoryDto();
    	 dto.getId();
    	 dto.setName(category.getName());
    	 dto.setCreated_date(category.getCreated_date());
    	 int rs = dao.insertData(dto);
    	 
    	 if(rs == 0) {
    		 model.addAttribute("error","Insert Failed");
    		 return "/categories/create";
    	 }
    	 
    	 return "redirect:/category";
    	 
     }
     

 	@RequestMapping(value="/setupdateCategory/{id}", method=RequestMethod.GET) 
 	public ModelAndView setupupdatebook(@PathVariable int id) {
 		CategoryDto dto = new CategoryDto();
 		dto.setId(id);
 		ModelAndView modelAndView = new ModelAndView("/categories/update","bean",dao.selectOne(dto));
		return modelAndView;
 		
 	}
     
     @RequestMapping(value="/update" ,method=RequestMethod.POST)
     public String updateCategory(@ModelAttribute("bean") @Validated Category category, BindingResult result, ModelMap model) {
		
    	 if(result.hasErrors()) {
 			model.addAttribute("error","Invalid Category required");
 			return "/categories/update";
 		}
    	 
    	 CategoryDto dto = new CategoryDto();
    	 dto.setId(category.getId());
    	 dto.setName(category.getName());
    	 dto.setCreated_date(category.getCreated_date());
    	 int rs = dao.updateData(dto);
    	 
    	 if(rs == 0) {
    		 model.addAttribute("error","Update Failed");
    		 return "/categories/update";
    	 }
    	 
    	 return "redirect:/category";
     }
     
     @RequestMapping(value="/deleteCategory/{id}", method=RequestMethod.GET) 
 	public String deletebook(@PathVariable int id,ModelMap model){	
    	 CategoryDto dto = new CategoryDto();
 			dto.setId(id);
 		int res = dao.deleteData(dto);
 		
 		if(res == 0) {
 			model.addAttribute("error","Delete Failed");
 			return "/categories/index";
 		}	
 		
 		 return "redirect:/category";
 	
 	}
     
     
}
