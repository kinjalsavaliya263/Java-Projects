package com.controller;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.UserProfile;
import com.service.CategoryService;
import com.service.ProductService;
import com.service.UserProfileService;

import net.bytebuddy.matcher.ModifierMatcher.Mode;

@Controller
public class Usercontroller {
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/")
	public ModelAndView index()
	{
			ModelAndView model = new ModelAndView();
			model.addObject("categories",categoryService.getAllCategory());
			model.addObject("products",productService.getAllProduct());
			model.setViewName("index");
			return model;
	}
	
	@RequestMapping("/userLogin")
	public ModelAndView userLogin()
	{
		ModelAndView model = new ModelAndView();
		model.addObject("userProfile", new UserProfile());
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping("/userReg")
	public ModelAndView userReg()
	{
		ModelAndView model = new ModelAndView();
		model.addObject("userProfile", new UserProfile());
		model.setViewName("registration");
		return model;
	}
	
	@RequestMapping(value = "/userRegistration",method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("userProfile") UserProfile p, BindingResult br)
	{
		if(br.hasErrors())
		{
			 return "registration";
		}
		else {
		userProfileService.addOrUpdateUser(p);
		return "registration";
		
		}
	
	}
	
	@RequestMapping(value = "/userLogin",method = RequestMethod.POST)
	public ModelAndView logincheck(@ModelAttribute("userProfile") UserProfile p, HttpServletRequest req)
	{
		ModelAndView model = new ModelAndView();
		UserProfile profile =   userProfileService.logincheck(p);
		if(profile==null)
		{
			model.addObject("error", "Invalid username or password");
			model.setViewName("login");
		}
		else
		{
			HttpSession session = req.getSession();
			session.setAttribute("user", profile.getFirstName());
			session.setAttribute("userId", profile.getUserId());
			model.setViewName("index");
		}
		return model;
	}
	
	@RequestMapping("/userLogout")
	public String logout(HttpServletRequest req)
	{
		HttpSession session = req.getSession(false);
		session.invalidate();
		return "index";
	}
	
	//************************shoping cart**************
	
	@RequestMapping("/shop-cart")
	public String openCart()
	{
		return "shop-cart";
	}
	
	@RequestMapping("/addCart")
	public void addToCart(@RequestParam("pid") int pid,HttpServletRequest req)
	{
		System.out.println("product id is : "+pid);
		HttpSession session = req.getSession();
		int uid = (int) session.getAttribute("userId");
		System.out.println("user id is : "+uid);
		
	}
}
