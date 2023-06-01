package com.ai.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import com.ai.form.validator.ImageFileExtension;




@Entity
@Table(name="product")
public class Product implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    @NotBlank(message = "Product name is required")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    @NotNull(message = "Image is required")
//    @Size(max = 5 * 1024 * 1024, message = "File size must not exceed 5MB")
//    @ImageFileExtension(message = "Only JPG, JPEG, and PNG file types are allowed")
    private MultipartFile image;
    
    @Column(name = "quantity")
    @NotNull(message = "Product Quantity is required")
    private Integer quantity;

    @Column(name = "price")
    @NotNull(message = "Product Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
    private Double price;

    @Column(name = "is_stock")
    @NotNull(message = "Stock status is required")
    private Integer is_stock;

    @Column(name = "category_id")
    @NotNull(message = "Product Category is required")
    private Integer category_id;

    @Column(name = "color_id")
    @NotNull(message = "Product Color is required")
    private int color_id;

    @Column(name = "size_id")
    @NotNull(message = "Product Size is required")
    private Integer size_id;
		
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

//		public boolean getIs_deleted() {
//			return is_deleted;
//		}
//		public void setIs_deleted(boolean is_deleted) {
//			this.is_deleted = is_deleted;
//		}
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

		public MultipartFile getImage() {
			return image;
		}
		
		public void setImage(MultipartFile image) {
			this.image = image;
		}

		public void setImage(String imageData) {
			// TODO Auto-generated method stub
			
		}
		
}
