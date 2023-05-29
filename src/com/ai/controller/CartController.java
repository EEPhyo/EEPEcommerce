package com.ai.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ai.model.Shopping_cart;
import com.ai.model.Item;
import com.ai.model.Product;
import com.ai.persistant.dao.CartDao;
import com.ai.persistant.dao.ProductDao;
import com.ai.service.CartService;
import com.ai.service.ProductService;

@Controller
@RequestMapping ("/cart")
	
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/")
    public String viewCart(Model model) {
        Shopping_cart cart = cartService.getCart();
        model.addAttribute("cart", cart);
        return "cart";
    }
	
	@GetMapping("/cart")
    public String showCart(Model model) {
        Shopping_cart cart = cartService.getCart();
        model.addAttribute("cart", cart);
        return "cart"; 
    }
	
	 @PostMapping("/add")
	    public String addItemToCart(@RequestParam("productId") int productId, @RequestParam("quantity") int quantity) {
	        Product product = ProductService.get(productId);
	        cartService.addItem(product, quantity);
	        return "redirect:/cart/";
	    }
	 
	@PostMapping("/update")
    public String updateCartItemQuantity(@RequestParam("itemId") int itemId, @RequestParam("quantity") int quantity) {
        cartService.updateItemQuantity(itemId, quantity);
        return "redirect:/cart/";
    }
	
	@PostMapping("/remove")
    public String removeItemFromCart(@RequestParam("itemId") int itemId) {
        cartService.removeItem(itemId);
        return "redirect:/cart/";
    }
	}
	
	
	
	


