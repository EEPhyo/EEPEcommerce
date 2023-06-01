package com.ai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import com.ai.model.Shopping_cart;
import com.ai.persistant.dao.CartDao;
import com.ai.persistant.dao.ProductDao;
import com.ai.persistant.dto.CartDto;
import com.ai.persistant.dto.ProductDto;
@Controller
public class CartController {
	
	@Autowired
	private CartDao cart_dao;
	
	@Autowired
	private ProductDao product_dao;
	
	
	
	@RequestMapping (value= "/cart", method=RequestMethod.POST)
	public String Cart(@ModelAttribute("cart") Shopping_cart cart, ModelMap model) {
		model.addAttribute("cart", new Shopping_cart());
		System.out.print(cart.getP_id());
		ProductDto dto=new ProductDto();
		dto.setId(cart.getP_id());
		ProductDao product_dao=new ProductDao();
		ProductDto list=product_dao.selectOne(dto);
		CartDto cart_dto=new CartDto();
		cart_dto.setP_id(list.getId());
		cart_dto.setPrice(list.getPrice());
		cart_dto.setQuantity(list.getQuantity());
		cart_dto.setUser_id(cart.getUser_id());
		CartDao cart_dao=new CartDao();
		cart_dao.insertData(cart_dto);
		return "redirect:/";	
	}
	
	@RequestMapping(value = "/cartview", method = RequestMethod.GET)
	public String CartView(ModelMap model, HttpSession session) {
		CartDao cart_dao=new CartDao();
		ArrayList<CartDto> list = cart_dao.selectAll(Integer.parseInt(session.getAttribute("ID").toString()));
		model.addAttribute("cartlist", list);
		ArrayList<Double> pricelist = cart_dao.selectAllPrice(Integer.parseInt(session.getAttribute("ID").toString()));
		double total = 0.0;

		for (double i : pricelist) {
			total += i;
		}

		model.addAttribute("total", total);
		session.setAttribute("total", total);
		return "cart";
	}
	
	@RequestMapping(value = "/cartviewremove/{Id}", method = RequestMethod.GET)
	public String CartViewRemove(ModelMap model, HttpSession session, @PathVariable int Id) {
		CartDao cart_dao = new CartDao();
		CartDto cart_dto = new CartDto();
		cart_dao.deleteData(Id);

		return "redirect:/cartview";

	}
	
	
	
	
}