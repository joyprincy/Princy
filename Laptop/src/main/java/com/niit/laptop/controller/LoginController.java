package com.niit.laptop.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.laptop.dao.CategoryDaoService;
import com.niit.laptop.model.Category;
import com.niit.laptop.model.Product;
import com.niit.laptop.model.Supplier;
import com.niit.laptop.model.User;

@Controller
public class LoginController
{
	@Autowired
	private CategoryDaoService categoryService;
	
	
	
	@RequestMapping("/")
	public String gotoh3()
	{
		return "h3";
	}
	@RequestMapping("/h2")
	public String gotoh2(Map<String,Object>model)
	{
		User user=new User();
		model.put("user", user);
		return "h2";
	}
	@RequestMapping("/welcome")
	public String gotowelcome()
	{
		return "welcome";
	}
	
	@RequestMapping("/h4")
	public String gotoh4(Map<String,Object>model)
	{
		User user=new User();
		model.put("user", user);
		
		return "h4";
	}

	@RequestMapping("/contact")
	public String gotocontact()
	{
		return "contact";
	}
	@RequestMapping("/About")
	public String gotoAbout()
	{
		return "About";
	}
	
	
	@RequestMapping("/Admin")
	public String gotoAdmin()
	{
		return "Admin";
	}
	@RequestMapping("/addproduct")

	public String gotoAddproduct(ModelMap model)
	{
		
		Product product=new Product();
		model.addAttribute("product", product);
		model.addAttribute("categorylist",this.categoryService.list());
		return "Addproduct";
	}


		@RequestMapping("/Product")
	public String gotoproduct()
	{
		return "product";
	}
	@RequestMapping("/addcategory")
	public String gotoAddcategory(Map<String,Object>model)
	{
		
		Category addcategory=new Category();
		model.put("addcategory", addcategory);
		
		return "Addcategory";
	}
	@RequestMapping("/Category")
	public String gotocategory()
	{
		return "category";
	}
	@RequestMapping("/addsupplier")
	public String gotoAddsuppplier(Map<String,Object>model)
	{
		
		Supplier addsupplier=new Supplier();
		model.put("addsupplier", addsupplier);
		
		return "Addsuppplier";
	}
	@RequestMapping("/Supplier")
	public String gotosupplier()
	{
		return "supplier";
	}
	
	
}
