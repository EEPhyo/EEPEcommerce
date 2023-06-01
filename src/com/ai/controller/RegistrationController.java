package com.ai.controller;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.crypto.password.PasswordEncoder;


import com.ai.model.User;
import com.ai.persistant.dao.RoleDao;
import com.ai.persistant.dao.UserDao;
import com.ai.persistant.dto.CategoryDto;
import com.ai.persistant.dto.RoleDto;
import com.ai.persistant.dto.UserDto;


@Controller
public class RegistrationController {
	@Autowired	 
	private UserDao dao;
	
	@Autowired
	private RoleDao roledao;
		 
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public ModelAndView showRegister(ModelMap model) {
		ArrayList<RoleDto> role= roledao.selectRole();
		model.addAttribute("roles",role);	
		 ModelAndView m = new ModelAndView("/auth/register");
		 m.addObject("bean",new User());		
		
		return m;
	}
	
	@RequestMapping(value="/registration",method=RequestMethod.POST) 
	public String registerProcess(@ModelAttribute("bean") @Validated User user,BindingResult bs,ModelMap model) {
		
		if(bs.hasErrors()) {
			model.addAttribute("error","Name,Email and Password required!");
			return "/auth/register";
		}
		
		
		 char[] nameA = user.getName().toCharArray();
		   
		    if(user.getName().equals(" ")){
		    	 model.addAttribute("error","Please enter a username.");
		    	return "/auth/register";
		    }else if(nameA.length <= 4) {
		    	model.addAttribute("error","Name should be more than 4 letter!");
		    	return "/auth/register";
		    }		    	
		    	
		    
		    for(int i=0;i<nameA.length;i++) {
		      int ascii=nameA[i];
		      
		      if(!(ascii > 64 && ascii < 91  || ascii > 96 && ascii < 123|| ascii==32)) {
		        model.addAttribute("error","Name can't contain special character or Number!");
		        return "/auth/register";
		      }
		    }
		    boolean error = false;
		    UserDao dao = new UserDao();
		    
		    ArrayList<UserDto> list = dao.User_List();
		    Iterator<UserDto> itr=list.iterator();
		    
		    while(itr.hasNext()) {
		    	UserDto dto=itr.next();
		    	
		    	if(user.getEmail().equals(dto.getEmail())) {
		    		model.addAttribute("error","Your Email is already exists!");
		    		error=true;
		    		return "/auth/register";
		    	}else if(!user.getEmail().endsWith("@gmail.com")) {
		    		model.addAttribute("error","Email Should Contain @gmail.com");
		    		error=true;
					return "/auth/register";
		    	}
		    	
		    }	
		    
		    if(user.getPhone_number() == null){
		    	model.addAttribute("error","Please enter your phone number");
		    	error=true;
	    		return "/auth/register";
			}
		    
		    	if (user.getPhone_number().matches("\\d{11}")) { 
		    	error=false;
		        //validating phone number with -, . or spaces
		    	}else if(user.getPhone_number().matches("\\d{2}[-]\\d{3}\\d{3}\\d{3}")) {
		        error=false;
				}else if(user.getPhone_number().matches("\\d{2}\\d{3}\\d{3}\\d{3}")) {
		        error=false;
		        //validating phone number with extension length from 3 to 5
				}else if(user.getPhone_number().matches("\\d{2}[-]\\d{4}\\d{5}")) {
		        error=false;
		        //validating phone number where area code is in braces ()
				}else if(user.getPhone_number().matches("[+]\\d[959]\\d{10}")) {
		        error=false;
		        //return false if nothing matches the input
				}else  {
		        model.addAttribute("error","Invalid format, valid formats are 09-123456789, 09123456789 , +959123456789");		        	
		        error=true;
		        return "/auth/register";
			} 
		    
		    if(user.getPassword().equals(" ")) {
		    	model.addAttribute("error","Please enter your password");
		    	error = true;
		    	return "/auth/register";
		    	
		    }else if(user.getConfirmPassword().equals(" ")) {
		    	model.addAttribute("error","Please enter your Confrim password");
		    	error = true;
		    	return "/auth/register";
			}else if(!user.getPassword().equals(user.getConfirmPassword())) {
	        	model.addAttribute("error","Password didn't match");
	        	error = true;
	            return "/auth/register";
	        }
		    
		    char[] password=user.getPassword().toCharArray();
			for(int i=0;i<password.length;i++) {
				int space=password[i];
				
				if(space == 10) {
					error = true;
					model.addAttribute("error","Password must not be contain space!");
				}
			}
			
			if(password.length < 6) {
				error = true;
				model.addAttribute("error","Password must be 7-20!!");
			}
			else if(password.length > 20){
			    error = true;
				model.addAttribute("error","Password must be 7-20!!");
			}
			

			if(user.getPassword().equals("12345678")) {
				error = true;
				model.addAttribute("error","Password is too weak!");
			}
			
						
			if(error== true) {
				return "/auth/register";
			}else {
				UserDto dto = new UserDto();
				dto.setName(user.getName());
				dto.setEmail(user.getEmail());
				String encodedPassword = passwordEncoder.encode(user.getPassword());
				dto.setPassword(encodedPassword);
				dto.setConfirmPassword((user.getConfirmPassword()));
				dto.setPhone_number(user.getPhone_number());
				dto.setAddress(user.getAddress());
				dto.setRole_id(2);
				int rs = dao.insertData(dto);	
				
				if(rs ==0) {
					model.addAttribute("error","Registration Failed");
					return "/auth/register";
				}	
							
				
			}		
		
			return "redirect:/login";	
			
		}
	
}
