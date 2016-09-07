package com.niit.laptop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.niit.laptop.dao.CategoryDaoService;
import com.niit.laptop.dao.ProductDaoService;
import com.niit.laptop.model.Category;
import com.niit.laptop.model.Product;
@Controller
public class ProductController {
	@Autowired
	private CategoryDaoService categoryService;
	String path = "A:/workspace/Laptop/src/main/webapp/resources/images/";
	@Autowired
	private ProductDaoService productService;
	@Autowired
	private Product product;
	@RequestMapping(value="addpro",method=RequestMethod.POST)
	public ModelAndView Addproductpost(@ModelAttribute("product") Product product,BindingResult result)
	{
		ModelAndView mv= new ModelAndView();
		if(result.hasErrors())
		{
			
			mv.setViewName("Addproduct");
		}
		else
		{
	
		
		System.out.println("category name  "+product.getCat().getName());
		Category category=categoryService.getByName(product.getCat().getName());
		
		System.out.println(product.getName());
		product.setCat(category);
		//System.out.println(product);
		if(product.getId()==0)
		{
	productService.saveOrUpdate(product);
		}
		else
		{
			productService.update(product);
		}
	//System.out.println(product.getName());
		//mv.addObject("product",product);
		MultipartFile file=product.getFile();
		FileUtil.upload(path,file,product.getId()+".jpg");
		mv.setViewName("redirect:/viewproduct");
		}	
		return mv;
	}
	/*@RequestMapping(value="/addproduct",method=RequestMethod.GET)
	public String Addproduct(ModelMap model)
	{
	Product product=new Product();
		model.put("product", product);
		model.addAttribute("categorylist",this.categoryService.list());
		return "Addproduct";
		}
*/

	@RequestMapping(value="viewproduct")
	public ModelAndView proview()
	{
		
		 ModelAndView  mv=new ModelAndView("viewproduct");
	 Gson gson=new Gson();
	 List<Product> pro=productService.list();
	 for(Product pr:pro)
	 {
		// System.out.println(pr.getName());
	 }
	 String pdata=gson.toJson(pro);
	
	// System.out.println(pdata);
	 //model.addAttribute("pdata",pdata);
 mv.addObject("pdata",pdata);
	 return mv;
}
	@RequestMapping(value="/del")
	public String delpro(HttpServletRequest request,ModelMap model){
		//System.out.println("in del contl");
		String iid=request.getParameter("proid");
		
		int id=Integer.parseInt(request.getParameter("proid"));
		
		//System.out.println("Id in delete"+iid);
		productService.delete(id);
		model.addAttribute("productList",productService.list());
		return "redirect:/viewproduct";
		
	}
	
	
	@RequestMapping(value="/edit")
	public String edit(HttpServletRequest request,ModelMap model){
	//System.out.println("welcome into edit");
	int id=Integer.parseInt(request.getParameter("proid"));
	//System.out.println("Id"+id);
	//System.out.println(product.getId());
	product=productService.get(id);
	//System.out.println(product.getId());
	
	//Product addproduct=new Product();
	//model.addAttribute("addproduct", addproduct);
	//model.addAttribute("categorylist",this.categoryService.list());
	model.addAttribute("product",product);
	model.addAttribute("categorylist",this.categoryService.list());
	//System.out.println(product.getName());
	return "Addproduct";
	}
		
	}
	
	  

	
	


