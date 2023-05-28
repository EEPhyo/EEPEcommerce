package com.ai.model;



public class CartItem {
	
	private Product product;
    private int quantity;
    private double totalPrice;

    // add an empty constructor
    public CartItem() {}

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = 1;
        this.totalPrice = product.getPrice();
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

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
