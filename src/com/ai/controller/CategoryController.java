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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
 		m.addAttribute("categories",list);		
 		return "/categories/index";
 		
 	}
     
     
    @RequestMapping(value="/setupaddCategory",method=RequestMethod.GET)
 	public ModelAndView setupaddCategory() {
 		return new ModelAndView("categories/create","bean",new Category());		
 		
 	} 	
     
     @RequestMapping(value="/create" ,method=RequestMethod.POST)
     public String addCategory(@ModelAttribute("bean") @Validated Category category, BindingResult result, ModelMap model) {
		
    	 if(result.hasErrors()) {
 			model.addAttribute("error","Invalid Category required");
 			return "/categories/create";
 		}
    	 
    	 CategoryDto dto = new CategoryDto();
    	 dto.getCategory_id();
    	 dto.setName(category.getName());
    	 dto.setCreated_date(category.getCreated_date());
    	 int rs = dao.insertData(dto);
    	 
    	 if(rs == 0) {
    		 model.addAttribute("error","Insert Failed");
    		 return "/categories/create";
    	 }
    	 
    	 return "redirect:/category";
    	 
     }
     @RequestMapping(value="/setupdateCategory/{category_id}", method=RequestMethod.GET) 
     public ModelAndView setupdateCategory(@PathVariable int category_id) {
         CategoryDto dto = new CategoryDto();         
         dto.setCategory_id(category_id);
         CategoryDto category = dao.selectOne(dto); 
         ModelAndView modelAndView = new ModelAndView("/categories/update");
         modelAndView.addObject("bean", category); 
         return modelAndView;
     }

     @RequestMapping(value = "/update", method = RequestMethod.POST)
     public String updateCategory(@ModelAttribute("bean") @Validated Category category, BindingResult result, ModelMap model) {
         if (result.hasErrors()) {
             model.addAttribute("error", "Invalid Category required");
             return "categories/update";
         } 	 
      
         CategoryDto dto = new CategoryDto();
         dto.setCategory_id(category.getCategory_id());    
         System.out.println(category.getCategory_id() + "eeee");
         dto.setName(category.getName());
         dto.setCreated_date(category.getCreated_date());
         int rs = dao.updateData(dto);
         if (rs == 0) {
             model.addAttribute("error", "Update Failed");             
             return "categories/update";
         }         	
 

         return "redirect:/category";
     }
     
 	 		
 	
     
     @RequestMapping(value="/deleteCategory/{category_id}",method=RequestMethod.GET)
     public String deleteCategory(@PathVariable("category_id") int category_id, ModelMap model,
                                  RedirectAttributes redirectAttributes) {
         CategoryDto dto = new CategoryDto();
         dto.setCategory_id(category_id);

         CategoryDto category = dao.selectOne(dto);
         if (category != null && category.getProducts() != null && !category.getProducts().isEmpty()) {
             redirectAttributes.addFlashAttribute("toastMessage",
                     "This category can't be deleted because it is being used in posts!");
             redirectAttributes.addFlashAttribute("toastType", "error");
         } else {
             dao.deleteData(dto);
             redirectAttributes.addFlashAttribute("toastMessage", "Category deleted successfully!");
             redirectAttributes.addFlashAttribute("toastType", "success");
         }

         int res = dao.deleteData(dto);
         if (res == 0) {
             model.addAttribute("error", "Delete Failed");
             return "/categories/index";
         }
         
         return "redirect:/category";
     }
 
     
}
