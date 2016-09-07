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
import com.niit.laptop.dao.SupplierDaoService;
import com.niit.laptop.model.Product;
import com.niit.laptop.model.Supplier;
@Controller
public class SupplierController {
	@Autowired
	private SupplierDaoService supplierService;
	@Autowired
	private Supplier supplier;
	@RequestMapping(value="addsupp",method=RequestMethod.POST)
	public ModelAndView Addsupplierpost(@ModelAttribute("supplier") Supplier supplier,BindingResult result,Model model )
	{
		supplierService.saveOrUpdate(supplier);
		ModelAndView modelAndView= new ModelAndView("/viewsupplier") ;
		modelAndView.addObject("supplier",supplier);
	
		
		return  modelAndView;
	}
	
	@RequestMapping(value="viewsupplier")
	public ModelAndView proview(Model model)
	{
		
	
	 Gson gson=new Gson();
	 List<Supplier> sup=supplierService.list();
	 String sdata=gson.toJson(sup);
	 ModelAndView  mv=new ModelAndView("viewsupplier");
	 System.out.println(sdata);
	 model.addAttribute("sdata",sdata);
// mv.addObject("pdata",pdata);
	 return mv;
}
	
	@RequestMapping(value="/dels")
	public String delsup(HttpServletRequest request,ModelMap model){
		System.out.println("in del contl");
		String iid=request.getParameter("supid");
		
		int id=Integer.parseInt(request.getParameter("supid"));
		
		System.out.println("Id in delete"+iid);
		supplierService.delete(id);
		model.addAttribute("supplierList",supplierService.list());
		return "redirect:/viewsupplier";
		
	}
	
	
	@RequestMapping(value="/edits")
	public String edit(HttpServletRequest request,ModelMap model){
	System.out.println("welcome into edit");
	int id=Integer.parseInt(request.getParameter("supid"));
	System.out.println("Id"+id);
	supplier=supplierService.get(id);
	System.out.println(supplier);
	model.addAttribute("supplier",supplier);
	return "add";
	}

}

