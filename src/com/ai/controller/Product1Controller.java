package com.ai.controller;

import java.io.BufferedOutputStream;
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
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public String createProduct(@ModelAttribute("bean") @Validated Product product,BindingResult result,HttpServletRequest req,ModelMap model,RedirectAttributes ra,HttpSession session) {
	
   	 if (result.hasErrors()) {
   		ArrayList<CategoryDto> categories= categorydao.selectAll();
	    	ArrayList<ColorDto> colors= colordao.selectAll();
	    	ArrayList<SizeDto> sizes = sizedao.selectAll();
			model.addAttribute("categories",categories);	
			model.addAttribute("colors",  colors);		
			model.addAttribute("sizes", sizes);
			ra.addFlashAttribute("error", "Field cannot blank!!");	
 			return "product/create";
   	 }
    	 
   	try {	
   		
			MultipartFile image = product.getImage();
			if (image == null || image.isEmpty()) {
				ArrayList<CategoryDto> categories= categorydao.selectAll();
				ArrayList<ColorDto> colors= colordao.selectAll();
		    	ArrayList<SizeDto> sizes = sizedao.selectAll();
				model.addAttribute("categories",categories);	
				model.addAttribute("colors",  colors);		
				model.addAttribute("sizes", sizes);
				model.addAttribute("error", "Image Required");
				return "product/create";
			}
			byte[] bytes = image.getBytes();
			
			System.out.print(bytes.length);
			if (bytes.length < 1) {
				ArrayList<CategoryDto> categories= categorydao.selectAll();
				ArrayList<ColorDto> colors= colordao.selectAll();
		    	ArrayList<SizeDto> sizes = sizedao.selectAll();
				model.addAttribute("categories",categories);	
				model.addAttribute("colors",  colors);		
				model.addAttribute("sizes", sizes);
				model.addAttribute("error", "Image Required");
				return "product/create";
			}
			
						 
	
			String uploadPath =session.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "image"
					+ File.separator + product.getImage().getOriginalFilename();

			String imagePath = "D:\\EEPEcommerce\\WebContent\\WEB-INF\\image";		
			
			File imageFile = new File(imagePath, image.getOriginalFilename());
			image.transferTo(imageFile);

			
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(uploadPath ));
			bout.write(bytes);
			bout.close();
		} catch (IOException e) {
			System.out.print(e);
		}
   		String imageData = product.getImage().getOriginalFilename();
			ProductDto dto=new ProductDto();
			dto.setId(product.getId());
			dto.setName(product.getName());
			dto.setDescription(product.getDescription());
			dto.setImage(imageData);
			dto.setQuantity(product.getQuantity());
			dto.setPrice(product.getPrice());
			dto.setIs_stock(product.getIs_stock());
			dto.setCategory_id(product.getCategory_id());
			dto.setColor_id(product.getColor_id());
			dto.setSize_id(product.getSize_id());
			int rs = dao.insertData(dto);			

			if(rs == 0) {
				ArrayList<CategoryDto> categories= categorydao.selectAll();
				ArrayList<ColorDto> colors= colordao.selectAll();
		    	ArrayList<SizeDto> sizes = sizedao.selectAll();
				model.addAttribute("categories",categories);	
				model.addAttribute("colors",  colors);		
				model.addAttribute("sizes", sizes);
				ra.addFlashAttribute("error","Your Insert fail");
				return "product/create";
			}	
			return "redirect:/productList";
   	 
    }         

	

	@RequestMapping(value="/editProduct/{id}", method=RequestMethod.GET)
    public ModelAndView editProduct(@PathVariable int id, ModelMap m) {
        ProductDto dto = new ProductDto();
        dto.setId(id);
        
        ArrayList<CategoryDto> categories = categorydao.selectAll();
        ArrayList<ColorDto> colors = colordao.selectAll();
        ArrayList<SizeDto> sizes = sizedao.selectAll();
        m.addAttribute("categories", categories);
        m.addAttribute("colors", colors);
        m.addAttribute("sizes", sizes);
        ProductDto product = dao.selectOne(dto);        
        ModelAndView modelAndView = new ModelAndView("/product/update");
        modelAndView.addObject("bean",product); 
        return modelAndView;
        
    }

    @RequestMapping(value="/updateProduct", method=RequestMethod.POST)
    public String updateProduct(@ModelAttribute("bean") @Validated Product product, BindingResult result,
                                HttpServletRequest req, ModelMap model, RedirectAttributes ra,
                                HttpSession session) {

        if (result.hasErrors()) {
        	ArrayList<CategoryDto> categories= categorydao.selectAll();
			ArrayList<ColorDto> colors= colordao.selectAll();
	    	ArrayList<SizeDto> sizes = sizedao.selectAll();
			model.addAttribute("categories",categories);	
			model.addAttribute("colors",  colors);		
			model.addAttribute("sizes", sizes);
			ra.addFlashAttribute("error","Your Insert fail");
            model.addAttribute("error", "Field can not be blank");
            return "product/update";
        }

      try {
            MultipartFile image = product.getImage();
            if (image != null && !image.isEmpty()) {
                byte[] bytes = image.getBytes();
                System.out.print(bytes.length);
                
                if (bytes.length < 1) {
                	ArrayList<CategoryDto> categories= categorydao.selectAll();
    				ArrayList<ColorDto> colors= colordao.selectAll();
    		    	ArrayList<SizeDto> sizes = sizedao.selectAll();
    				model.addAttribute("categories",categories);	
    				model.addAttribute("colors",  colors);		
    				model.addAttribute("sizes", sizes);
    				ra.addFlashAttribute("error","Your Insert fail");
                    model.addAttribute("error", "Image Required");
                    return "product/update";
                }

                String uploadPath = session.getServletContext().getRealPath("/") + "WEB-INF" +
                                    File.separator + "image" + File.separator + image.getOriginalFilename();

                String imagePath = "D:\\EEPEcommerce\\WebContent\\WEB-INF\\image";
                
                File imageFile = new File(imagePath, image.getOriginalFilename());
                image.transferTo(imageFile);

                BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(uploadPath));
                bout.write(bytes);
                bout.close();

                              
            }
        } catch (IOException e) {
            System.out.print(e);
        }
	      String imageData = product.getImage().getOriginalFilename();
	    
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setCategory_id(product.getCategory_id());
        dto.setColor_id(product.getColor_id());
        dto.setSize_id(product.getSize_id());
        dto.setDescription(product.getDescription());
        dto.setImage(imageData);
        dto.setQuantity(product.getQuantity());
        dto.setPrice(product.getPrice());
        dto.setIs_stock(product.getIs_stock());
        int rs = dao.updateData(dto);

        if (rs == 0) {
        	ArrayList<CategoryDto> categories= categorydao.selectAll();
			ArrayList<ColorDto> colors= colordao.selectAll();
	    	ArrayList<SizeDto> sizes = sizedao.selectAll();
			model.addAttribute("categories",categories);	
			model.addAttribute("colors",  colors);		
			model.addAttribute("sizes", sizes);
			ra.addFlashAttribute("error","Your Insert fail");
            ra.addAttribute("error", "Your update failed");
            return "product/update";
        }

        return "redirect:/productList";
    }

    
    @RequestMapping(value="/deleteProduct/{id}", method=RequestMethod.GET) 
 	public String deleteProduct(@PathVariable int id,ModelMap model){	
    	 ProductDto dto = new ProductDto();    	 
 			dto.setId(id);
 			int res = dao.deleteData(dto);
 		
 		if(res == 0) {
 			model.addAttribute("error","Delete Failed");
 			return "redirect:/productList";
 		}	
 		
 		 return "redirect:/productList";
 	
 	}
    
   
    
 
}

