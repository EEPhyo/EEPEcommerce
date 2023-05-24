package com.ai.controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ai.model.User;
import com.ai.persistant.dao.AccountDao;
import com.ai.persistant.dto.UserDto;

@Controller
public class LoginController {

	@Autowired
	private AccountDao account;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showRegister(ModelMap model) {
		ModelAndView mav = new ModelAndView("/auth/login");
		mav.addObject("bean", new User());
		return mav;
	}

	@RequestMapping(value = "/LoginProcess", method = RequestMethod.POST)
	public String loginProcess(@ModelAttribute("bean") @Validated User user, BindingResult result, ModelMap model,
			HttpSession session) throws Exception {

		if (result.hasFieldErrors("email") || result.hasFieldErrors("password")) {
			model.addAttribute("error", "Email and Password required!");
			return "redirect:/auth/login";
		}

		if (!user.getEmail().endsWith("@gmail.com")) {
			model.addAttribute("error", "Email should contain @gmail.com!");
			return "redirect:/auth/login";
		}
		
		if(user.getEmail().equals(" ") && user.getPassword().equals(" ") && user.getEmail().equals(null) && user.getPassword().equals(null)) {
			model.addAttribute("error", "Invalid Email or Password!");
			return "redirect:/auth/login";
		}

		String view=null;
		if (user.getEmail().equals("johndoe@gmail.com") && user.getPassword().equals("admin123")) {
			ArrayList<UserDto> adminList = account.selectAllAdmin();
			Iterator<UserDto> adminIterator = adminList.iterator();

			while (adminIterator.hasNext()) {
				UserDto userdto = adminIterator.next();

				if (user.getEmail().equals(userdto.getEmail()) && user.getPassword().equals(userdto.getPassword())) {
					session.setAttribute("Id", userdto.getId());
					session.setAttribute("Email", userdto.getEmail());
					return "redirect:/list";
				}else {
					model.addAttribute("error", "Invalid Email or Password!");
					return "/auth/login";
				}
//			}
////		} else {
////			ArrayList<UserDto> userList = account.selectAllUser();
////		Iterator<UserDto> userIterator = userList.iterator();
////
////		while (userIterator.hasNext()) {
////				UserDto userdto = userIterator.next();
////
////				if (user.getEmail().equals(userdto.getEmail()) && user.getPassword().equals(userdto.getPassword())) {
////					session.setAttribute("Id", userdto.getId());
////				session.setAttribute("Email", userdto.getEmail());
////					view="/frontend/checkout";
////			}
////		}
//
		}
		}
		return "redirect:/list";
	}
}
