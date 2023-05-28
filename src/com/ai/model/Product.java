package com.ai.model;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="product")

public class Product implements Serializable{

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		
		@Column(name="name")
		@NotEmpty
		private String name;
		
		@Column(name="description")
		@NotEmpty
		private String description;
		
		@Column(name="image")
	
//		@Size(max = 5 * 1024 * 1024, message = "Maximum file size exceeded")
		private MultipartFile image;
		
		
		@Column(name="quantity")
		private int quantity;
		
	
		@Column(name="price")
		private double price;

		@Column(name="is_stock")
		private boolean is_stock;
		
		@Column(name="is_deleted")
		private boolean is_deleted;
		
		@Column(name="category_id")
		private int category_id;
		
		@Column(name="color_id")
		private int color_id;
		
		@Column(name="size_id")
		private int size_id;
		
		public Product() {}
		
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
		public boolean getIs_stock() {
			return is_stock;
		}
		public void setIs_stock(boolean is_stock) {
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

		public MultipartFile getImage() {
			return image;
		}
		
		public void setImage(MultipartFile image) {
			this.image = image;
		}
}
