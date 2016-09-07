package com.niit.laptop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.laptop.dao.CategoryDaoService;
import com.niit.laptop.model.Category;
@Controller
public class CategoryController {
	@Autowired
	private CategoryDaoService categoryService;
	@Autowired
	private Category category;
	@RequestMapping(value="addcat",method=RequestMethod.POST)
	public ModelAndView Addcategorypost(@ModelAttribute("category") Category category,BindingResult result,Model model )
	{
		categoryService.saveOrUpdate(category);
		ModelAndView modelAndView= new ModelAndView("/viewcategory") ;
		modelAndView.addObject("category",category);
		return  modelAndView;
	}
	/*@RequestMapping(value="/addcategory",method=RequestMethod.GET)
	public String Addcategory(ModelMap model)
	{
		Category category=new Category();
		model.put("category", category);
		model.addAttribute("categorylist",this.categoryService.list());
		return "Addcategory";
		}
*/
	@RequestMapping(value="viewcategory")
	public ModelAndView proview(Model model)
	{
		
	
	 Gson gson=new Gson();
	 List<Category> cat=categoryService.list();
	 String cdata=gson.toJson(cat);
	 ModelAndView  mv=new ModelAndView("viewcategory");
	 System.out.println(cdata);
	 model.addAttribute("cdata",cdata);
// mv.addObject("pdata",pdata);
	 return mv;
}
	@RequestMapping(value="/dele")
	public String delpro(HttpServletRequest request,ModelMap model){
		System.out.println("in del contl");
		String iid=request.getParameter("catid");
		
		int id=Integer.parseInt(request.getParameter("catid"));
		
		System.out.println("Id in delete"+iid);
		categoryService.delete(id);
		model.addAttribute("categoryList",categoryService.list());
		return "redirect:/viewcategory";
		
	}
	
	
	/*@RequestMapping(value="/editc")
	public String edit(HttpServletRequest request,ModelMap model){
	System.out.println("welcome into edit");
	int id=Integer.parseInt(request.getParameter("catid"));
	System.out.println("Id"+id);
	category=categoryService.get(id);
	System.out.println(category);
	model.addAttribute("category",category);
	return "Addcategory";
	}
		
*/
	
	
	
	
}
