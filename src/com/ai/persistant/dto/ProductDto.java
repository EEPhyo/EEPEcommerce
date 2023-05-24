package com.ai.persistant.dto;

import java.io.Serializable;

public class ProductDto implements Serializable {
	private int id;
	private String name;
	private String description;
	private String image;
	private String quantity;
	private double price;
	private boolean is_stock;
	private boolean is_deleted;

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public boolean isIs_stock() {
		return is_stock;
	}


	public void setIs_stock(boolean is_stock) {
		this.is_stock = is_stock;
	}


	public boolean isIs_deleted() {
		return is_deleted;
	}


	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}


	public ProductDto() {}
	}
