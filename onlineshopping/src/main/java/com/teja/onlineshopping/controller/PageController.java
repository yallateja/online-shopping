package com.teja.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index(){
		
		ModelAndView m=new ModelAndView("page");
		m.addObject("title", "Home");
		m.addObject("userClickHome", true);
		return m;
	}
	
	@RequestMapping(value={"/about"})
	public ModelAndView about(){
		
		ModelAndView m=new ModelAndView("page");
		m.addObject("title", "About us");
		m.addObject("userClickAbout", true);
		return m;
	}
	@RequestMapping(value={"/contact"})
	public ModelAndView contact(){
		
		ModelAndView m=new ModelAndView("page");
		m.addObject("title", "Contact us");
		m.addObject("userClickContact", true);
		return m;
	}

}
