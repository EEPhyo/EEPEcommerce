package com.ai.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ai.model.Product;
import com.ai.persistant.dao.CategoryDao;
import com.ai.persistant.dao.ColorDao;
import com.ai.persistant.dao.ProductDao;
import com.ai.persistant.dao.SizeDao;
import com.ai.persistant.dto.CategoryDto;
import com.ai.persistant.dto.ColorDto;
import com.ai.persistant.dto.ProductDto;
import com.ai.persistant.dto.SizeDto;

@Controller
public class Product1Controller {
	
	
	@Autowired
	private ProductDao dao;
	
	@Autowired
    private CategoryDao categorydao;
	
	@Autowired
	private ColorDao colordao;
	
	@Autowired
	private SizeDao sizedao;
	
	
	
	@RequestMapping(value = "/productList", method = RequestMethod.GET)
	public String displayView(ModelMap m) throws IOException {
	    ArrayList<ProductDto> list = dao.selectAll();

	    for (ProductDto product : list) {
	        String imageData = product.getImage();
	        String base64Image = "";

	        if (imageData != null && !imageData.isEmpty()) {
	        	
	        	try {
	        		byte[] imageBytes = Files.readAllBytes(Paths.get(imageData));
					base64Image = Base64.getEncoder().encodeToString(imageBytes);
	        		
	        	}catch(IOException e) {
	        		System.out.println("Error reading image file: "+e.getMessage());
	        	}
	        	
	        }
	        
	        product.setBase64Image(base64Image);				

	       }
    

	    m.addAttribute("products", list);
	    return "/product/index";
	}

    
    
    @RequestMapping(value="/addProduct",method=RequestMethod.GET)
 	public String addProduct(ModelMap m) {
    	ArrayList<CategoryDto> categories= categorydao.selectAll();
    	ArrayList<ColorDto> colors= colordao.selectAll();
    	ArrayList<SizeDto> sizes = sizedao.selectAll();
		m.addAttribute("categories",categories);	
		m.addAttribute("colors",  colors);		
		m.addAttribute("sizes", sizes);
		m.addAttribute("bean", new ProductDto());
 		return "/product/create";
	} 	
    
    @RequestMapping(value="/createProduct" ,method=RequestMethod.POST)
    public String createProduct(@ModelAttribute("bean") @Validated Product product,BindingResult result,HttpServletRequest req,ModelMap model,RedirectAttributes ra) {
	
   	 if (result.hasErrors()) {
 			model.addAttribute("error", "Field can not be blank");
 			return "redirect:/addProduct";
 		} else {
    	 
			MultipartFile file = product.getImage();
			String imageFile = file.getOriginalFilename();
			String path = req.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resource" + File.separator + "image" + File.separator + imageFile;

			try {
				FileOutputStream fos = new FileOutputStream(path);
				InputStream is = file.getInputStream();
				byte[] data = new byte[is.available()];
				
				is.read(data);
				fos.write(data);
				fos.close();
			
				
				ProductDto dto=new ProductDto();
				dto.getId();
				dto.setName(product.getName());
				dto.setCategory_id(product.getCategory_id());
				dto.setColor_id(product.getColor_id());
				dto.setSize_id(product.getSize_id());
				dto.setImage(file.getOriginalFilename());
				dto.setDescription(product.getDescription());				
				dto.setQuantity(product.getQuantity());
				dto.setPrice(product.getPrice());
				dto.setIs_stock(product.getIs_stock());	
				
//				dto.setIs_deleted(product.getIs_deleted());
				int rs = dao.insertData(dto);
			
			if(rs == 0) {
					ra.addFlashAttribute("error","Your insert fail");
					return "redirect:/addProduct";
				}
			} catch (Exception e) {
			System.out.println("Image Upload error" + e);
			}
			
	 	 
   	 return "redirect:/productList";
   	 
    }     
  }  
     
     
    @RequestMapping(value="/editProduct/{id}",method=RequestMethod.GET)
  	public ModelAndView editProduct() {
  		return new ModelAndView("/product/update","bean",new Product());		
  		
  	} 	
    
    @RequestMapping(value="/updateProduct" ,method=RequestMethod.POST)
    public String editProduct(@ModelAttribute("bean") @Validated Product product,BindingResult result,HttpServletRequest req,ModelMap model,RedirectAttributes ra) {
		
   	 if (result.hasErrors()) {
			model.addAttribute("error", "Field can not be blank");
			return "redirect:/editProduct";
		} else {
   	 
			MultipartFile file = product.getImage();
			 String imageFile =file.getOriginalFilename();
			 String path = req.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resource" + File.separator + "image" + File.separator + imageFile;

			try {
				FileOutputStream fos = new FileOutputStream(path);
				InputStream is = file.getInputStream();
				byte[] data = new byte[is.available()];
				is.read(data);
				fos.write(data);
				fos.close();
				

				
				ProductDto dto=new ProductDto();
				dto.setId(product.getId());
				dto.setName(product.getName());
				dto.setDescription(product.getDescription());
				dto.setImage(file.getOriginalFilename());
				dto.setQuantity(product.getQuantity());
				dto.setPrice(product.getPrice());
				dto.setIs_stock(product.getIs_stock());
				dto.setCategory_id(product.getCategory_id());
				dto.setColor_id(product.getColor_id());
				dto.setSize_id(product.getSize_id());
//				dto.setIs_deleted(product.getIs_deleted());
				int rs = dao.insertData(dto);
				
				if(rs == 0) {
					ra.addFlashAttribute("error","Your insert fail");
					return "redirect:/editProduct";
				}	
				
			} catch (Exception e) {
				System.out.println("Image Upload error" + e);
			}
			
			
   	 
			 return "redirect:/productList";
		}
   	 
    }
    
    @RequestMapping(value="/deleteProduct/{id}", method=RequestMethod.GET) 
 	public String deletebook(@PathVariable int id,ModelMap model){	
    	 ProductDto dto = new ProductDto();
    	 ProductDao dao = new ProductDao();
 			dto.setId(id);
 			int res = dao.deleteData(dto);
 		
 		if(res == 0) {
 			model.addAttribute("error","Delete Failed");
 			return "/product/index";
 		}	
 		
 		 return "redirect:/productList";
 	
 	}
    
 
}

