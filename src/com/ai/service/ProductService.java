package com.ai.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.model.Product;
import com.ai.persistant.dao.ProductDao;
import com.ai.persistant.dto.ProductDto;

@Service
public class ProductService {
	
	private ProductDao productDao;

	    @Autowired
	    public ProductService(ProductDao productDao) {
	        this.productDao = productDao;
	    }


		public void addProduct(Product product) {
			// TODO Auto-generated method stub
			 productDao.addProduct(product);
		}


		public List<Product> getAllProducts() {
			// TODO Auto-generated method stub
			return null;
		}


		public ArrayList<ProductDto> getProductById(String productId) {
			
			return productDao.selectAll();
		}


		public void deleteProduct(String productId) {
			// TODO Auto-generated method stub
			
		}


		public void editProduct(Product product) {
			// TODO Auto-generated method stub
			
		}
	}

