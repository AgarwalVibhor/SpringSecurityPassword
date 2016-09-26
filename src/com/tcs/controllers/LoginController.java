package com.tcs.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/")
	public ModelAndView start()
	{
		ModelAndView model = new ModelAndView("redirect:/admin");
		return model;
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView admin()
	{
		ModelAndView model = new ModelAndView("admin");
		model.addObject("title", "Spring Security - Password Hashing");
		model.addObject("message", "This page can only be accessed by the Admin guys !!");
		return model;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout)
	{
		ModelAndView model = new ModelAndView("login");
		if(error != null)
		{
			model.addObject("error", "Invalid Username and Password !!");
		}
		if(logout != null)
		{
			model.addObject("logout", "You have logged out successfully !!");
		}
		return model;
	}
	

}
