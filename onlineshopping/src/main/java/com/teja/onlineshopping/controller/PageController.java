package com.teja.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView getHome(){
		
		ModelAndView m=new ModelAndView("page");
		m.addObject("greeting", "Welcom to MVC");
		return m;
	}

}
