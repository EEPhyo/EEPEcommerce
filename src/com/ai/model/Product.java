package com.ai.model;

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

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="product")

public class Product implements Serializable{

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		
		@Column(name="name")
		private String name;
		
		@Column(name="description")
		private String description;
		
		@Column(name="image")
		private String image;
		
		@Column(name="quantity")
		private String quantity;
		
		@Column(name="price")
		private double price;

		@Column(name="is_stock")
		private boolean is_stock;
		
		@Column(name="is_deleted")
		private boolean is_deleted;
		
		@ManyToOne(fetch = FetchType.LAZY, optional = false)
		@JoinColumn(name="category_id",nullable = false)
		private Category category;
		
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

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
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
		public void setProductCategory(String string) {
			// TODO Auto-generated method stub
			
		}
		public MultipartFile getProductImage() {
			// TODO Auto-generated method stub
			return null;
		}
		public String getProductId() {
			// TODO Auto-generated method stub
			return null;
		}
		public Product getProductById(int productId) {
			// TODO Auto-generated method stub
			return null;
		}
}
