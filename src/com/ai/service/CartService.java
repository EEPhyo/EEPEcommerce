package com.ai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ai.model.Shopping_cart;
import com.ai.model.CartItem;
import com.ai.model.Product;
import com.ai.model.Shopping_cart;
@Service
public class CartService {
	private Shopping_cart cart;
	
	public CartService() {
        this.cart = new Shopping_cart();
    }
	
	public Shopping_cart getCart() {
		return cart;
	}
	
	 public void addItem(Product product, int quantity) {
	        CartItem item = new CartItem(product, quantity);
	        cart.addItem(item);
	    }
	
	 public void updateItemQuantity(int itemId, int quantity) {
	        CartItem item = findItemById(itemId);
	        if (item != null) {
	            item.setQuantity(quantity);
	        }
	    }
	 
	 public void removeItem(int itemId) {
	        CartItem item = findItemById(itemId);
	        if (item != null) {
	            cart.removeItem(item);
	        }
	    }

	    public void setCart(Shopping_cart cart) {
		this.cart = cart;
	}

		private CartItem findItemById(int itemId) {
	    	for (CartItem item : cart.) {
	            if (item.getId() == itemId) {
	                return item;
	            }
	        }
	        return null; // Item not found
	    }

}
