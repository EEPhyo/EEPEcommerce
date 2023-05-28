//package com.ai.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.ai.model.ProductModel;
//
//@Controller
//
//public class ProductController {
//	@RequestMapping(value="/product",method = RequestMethod.GET)
//	public String index(ModelMap modelMap) {
//		ProductModel productModel = new ProductModel();
//		modelMap.put("products", productModel.findAll());
//		return "product";
//	}
//
//}
