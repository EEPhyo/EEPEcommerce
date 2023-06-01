package com.ai.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ai.model.Product;
@Entity
@Table(name="shopping_cart")
public class Shopping_cart implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sc_id;
	private int quantity;
	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	private int p_id;
	private int user_id;
	private double price;
	private double total_price;
	


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	

	public int getSc_id() {
		return sc_id;
	}

	public void setSc_id(int sc_id) {
		this.sc_id = sc_id;
	}
	
	
}