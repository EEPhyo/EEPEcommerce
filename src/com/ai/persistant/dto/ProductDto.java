package com.ai.persistant.dto;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name="product")

public class ProductDto implements Serializable{

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		
		private String name;
		
		private String description;
		
		private String image;
		
		private int quantity;
		
	
		private double price;

		private int is_stock;
		
		private boolean is_deleted;
		
		private int category_id;
		
		private int color_id;
		
		private int size_id;
		
		@Transient
		private String category_name;
		
		
		@Transient
	    private String size_value;

		 @Transient
		 private String color_name;
		 
		 
//		 @Transient
//		 private String base64Image;

		 
		public ProductDto() {}
		
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

		public boolean getIs_deleted() {
			return is_deleted;
		}
		public void setIs_deleted(boolean is_deleted) {
			this.is_deleted = is_deleted;
		}
		public int getIs_stock() {
			return is_stock;
		}
		public void setIs_stock(int is_stock) {
			this.is_stock = is_stock;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
				
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public void setCategory_id(int category_id) {
			this.category_id = category_id;
		}
		
		public int getCategory_id() {
			return category_id;
		}

		public int getColor_id() {
			return color_id;
		}

		public void setColor_id(int color_id) {
			this.color_id = color_id;
		}

		public int getSize_id() {
			return size_id;
		}

		public void setSize_id(int size_id) {
			this.size_id = size_id;
		}

		public String getImage() {
			return image;
		}
		
		public void setImage(String image) {
			this.image = image;
		}

		public void setImage(byte[] bytes) {
			// TODO Auto-generated method stub
			
		}
		
		
		public void setCategory_name(String category_name) {
			 this.category_name = category_name;
			
		}
		public String getCategory_name() {
		    return category_name;
		}


		 public String getSize_value() {
		        return size_value;
		 }

		public void setSize_value(String size_value) {
		        this.size_value = size_value;
		  }

		public String getColor_name() {
	        return color_name;
	    }

	    public void setColor_name(String color_name) {
	        this.color_name = color_name;
	    }
		    
//		 public String getBase64Image() {
//		        return base64Image;
//		  }
//
//		  public void setBase64Image(String base64Image) {
//		        this.base64Image = base64Image;
//		  }
//	    
	    
}
