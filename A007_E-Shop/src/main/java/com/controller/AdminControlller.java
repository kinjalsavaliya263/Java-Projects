package com.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.model.Category;
import com.model.Product;
import com.service.CategoryService;
import com.service.ProductService;
import com.service.UserProfileService;

@Controller
public class AdminControlller {
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/adminlogin")
	public ModelAndView adminLogin()
	{
		ModelAndView model = new ModelAndView();
		model.setViewName("adminlogin");
		return model;
	}
	
	@RequestMapping("/adminHome")
	public String adminHome()
	{
		return "adminhome";
	}
	
	@RequestMapping("/users")
	public ModelAndView adminUsers()
	{
		ModelAndView model = new ModelAndView();
		model.addObject("data",userProfileService.getallUsers());
		
		model.setViewName("adminuser");
		return model;
	}
	//*************************category********************
	
	@RequestMapping("/categories")
	public ModelAndView productCategory()
	{
		ModelAndView model = new ModelAndView();
		model.addObject("category",new Category());
		model.addObject("data",categoryService.getAllCategory());
		model.setViewName("productCategory");
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "addCatagory")
	public ModelAndView addCatagory(@ModelAttribute("catagory") Category category)
	{
		ModelAndView model = new ModelAndView();
		categoryService.addOrUpdateCate(category);
		model.setViewName("redirect:categories");
		return model;
	}
	
	@RequestMapping("updateCat")
	public ModelAndView updatecat(@RequestParam("uid") int uid)
	{
		ModelAndView model = new ModelAndView();
		model.addObject("category",categoryService.getCatById(uid));
		model.addObject("data",categoryService.getAllCategory());
		model.setViewName("productCategory");
		return model;
	}
	
	@RequestMapping("deleteCat")
	public ModelAndView deleteCat(@RequestParam("uid") int uid)
	{
		ModelAndView model = new ModelAndView();
		categoryService.deleteCategory(uid);
		model.setViewName("redirect:categories");
		return model;
	}
	
	
	
	
	
	//*************************product********************
	
		@RequestMapping("/products")
		public ModelAndView product()
		{
			ModelAndView model = new ModelAndView();
			model.addObject("product", new Product());
			model.addObject("categories", categoryService.getAllCategory());
			model.addObject("products",productService.getAllProduct());
			model.setViewName("product");
			return model;
		}
		
		@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
		public ModelAndView addProduct(@ModelAttribute("product") Product product, @RequestParam("catid") int id, @RequestParam CommonsMultipartFile file, HttpSession session)
		{
			String path =  session.getServletContext().getRealPath("/WEB-INF/Resources/productImage");
			//String path = "D:\\Classwork\\27Jan_java\\A007_E-Shop\\src\\main\\webapp\\WEB-INF\\Resources\\img\\product";
			String filepath = path+File.separator+file.getOriginalFilename();
			System.out.println(filepath);
			File f = new File(path);
			if(!f.exists())
			{
				f.mkdir();
			}
			
			byte b[] = file.getBytes();
			try {
				FileOutputStream fos = new FileOutputStream(new File(filepath));
				fos.write(b);
				fos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Category cat = categoryService.getCatById(id);
			product.setImage(file.getOriginalFilename());
			product.setCategory(cat);
			productService.addOrUpdateProduct(product);
			ModelAndView model = new ModelAndView();
			
			model.setViewName("redirect:products");
			return model;
		}
		
		@RequestMapping("updateProduct")
		public ModelAndView updateProduct(@RequestParam("uid") int uid)
		{
			ModelAndView model = new ModelAndView();
			model.addObject("product", productService.getProductById(uid));
			model.addObject("categories", categoryService.getAllCategory());
			model.addObject("products",productService.getAllProduct());
			model.setViewName("product");
			return model;
		}
		
		@RequestMapping("deleteProduct")
		public ModelAndView deleteProduct(@RequestParam("uid") int uid)
		{
			ModelAndView model = new ModelAndView();
			productService.deleteProduct(uid);
			model.setViewName("redirect:products");
			return model;
		}
}
