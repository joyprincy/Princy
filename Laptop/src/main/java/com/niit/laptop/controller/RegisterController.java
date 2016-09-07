package com.niit.laptop.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.laptop.dao.UserDaoService;
import com.niit.laptop.model.User;


@Controller
public class RegisterController {
	
	@Autowired
	private UserDaoService userService;
	@Autowired
	private User user;
	@RequestMapping(value="register",method=RequestMethod.POST)
	public ModelAndView h2post(@Valid@ModelAttribute("user") User user,BindingResult result,Model model )
	{
		/*if(result.hasErrors())
		{
			ModelAndView model1=new ModelAndView("h4");
			return model1;
		}*/
		userService.saveOrUpdate(user);
		ModelAndView modelAndView= new ModelAndView("h2") ;
		modelAndView.addObject("regsucess","Registered Succesfully..Please login");
		
		return  modelAndView;
	}
	@RequestMapping(value="checklogin")
	public ModelAndView gotocheck(@RequestParam("username")String username,@RequestParam("password")String password,HttpSession session)
	{
	ModelAndView mv=new ModelAndView();
	 boolean isValidUser=userService.isValidUser(username,password);
	 System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		if(isValidUser==true)
		{
			user=userService.get(username);
			session.setAttribute("loggedInUser", user.getUsername());
				User list=userService.get(username);
				String role=list.getRole();
			
		if(role.equals("ROLE_ADMIN")){
		 mv=new ModelAndView("/Admin");
		 mv.addObject("welcome","welcome"+list.getUsername());
		 mv.addObject("welcome","HI Admin");
		 return mv;
			
		}
		else
		{
			 mv=new ModelAndView("/h3");
			 mv.addObject("welcomeuser","You have successfully loggedin");
			 return mv;
		}
		}
		else
		{
			 mv=new ModelAndView("/h2");
			mv.addObject("inValidCredentials","true");
			mv.addObject("welcome","mismatching occurs..pls try again");
			return mv;
			}

	}
	@RequestMapping(value="logout")
	public ModelAndView logout(HttpServletRequest request,HttpSession session)
	{
		ModelAndView modelAndView=new ModelAndView("h3");
		session.invalidate();
		session=request.getSession(true);
		modelAndView.addObject("loggedOut","true");
		modelAndView.addObject("logout","Loggedout Successfully");
		 return modelAndView;
	}
		
	
	}
	
	
	
