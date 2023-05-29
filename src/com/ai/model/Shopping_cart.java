package com.ai.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="shopping_cart")

public class Shopping_cart implements Serializable  {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "user_id")
    private @NotBlank Integer userId;

    @Column(name = "product_id")
    private @NotBlank Long productId;

    @Column(name = "created_date")
    private Date createdDate;
    
    @ManyToOne
    @JoinColumn(name = "product", referencedColumnName = "id", insertable = false, updatable = false)
	
    private Product product;
    private int quantity;
    private List<CartItem> cartItems;	
    
    public Shopping_cart() {
    	this.cartItems = new ArrayList<>();
    }
    
    public void addItem(CartItem item) {
    	// Check if the item already exists in the cart
        for (CartItem existingItem : cartItems) {
            if (existingItem.getProduct().getId() == item.getProduct().getId()) {
                // Item already exists, update the quantity
                existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
                return;
            }
        }
        
        // Item does not exist, add it to the cart
        cartItems.add(item);
    }
    
    public void removeItem(CartItem item) {
        cartItems.remove(item);
    }
    
    public void updateQuantity(CartItem item, int quantity) {
        // Update the quantity of an item in the cart
    	// Find the item in the cart
        for (CartItem cartItem : cartItems) {
            if (cartItem.equals(item)) {
                cartItem.setQuantity(quantity);
                return;
            }
        }
    }
    
    public double getTotalPrice() {
        // Calculate and return the total price of all items in the cart
    	double totalPrice = 0.0;
        
        for (CartItem item : cartItems) {
            totalPrice += item.getProduct().getPrice() * item.getQuantity();
        }
        
        return totalPrice;
    }
    
    



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
    
	

}
