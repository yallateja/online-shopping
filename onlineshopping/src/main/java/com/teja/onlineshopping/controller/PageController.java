package com.teja.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.teja.onlineshopping.exception.ProductNotFoundException;
import com.teja.shoppingbackend.dao.CategoryDAO;
import com.teja.shoppingbackend.dao.ProductDAO;
import com.teja.shoppingbackend.dto.Category;
import com.teja.shoppingbackend.dto.Product;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index(){
		
		ModelAndView m=new ModelAndView("page");
		m.addObject("title", "Home");
		
		m.addObject("categories",categoryDAO.list());
		
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
	
	@RequestMapping(value="/show/all/products")
	public ModelAndView showAll(){
		
		ModelAndView m=new ModelAndView("page");
		m.addObject("title", "All products");
		
		m.addObject("categories",categoryDAO.list());
		
		m.addObject("userClickAllProducts", true);
		return m;
	}
	@RequestMapping(value="/show/category/{id}/products")
	public ModelAndView showByCategory(@PathVariable ("id") int id){
		
		ModelAndView m=new ModelAndView("page");
		
		
		Category category=categoryDAO.get(id);
		m.addObject("title", category.getName());
		
		m.addObject("categories",categoryDAO.list());
		m.addObject("category", category);
		
		m.addObject("userClickCategoryProducts", true);
		return m;
	}
	
	@RequestMapping(value = "/show/{id}/product") 
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException  {
		
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		
		if(product == null) throw new ProductNotFoundException();
		
		// update the view count
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		//---------------------------
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		
		mv.addObject("userClickShowProduct", true);
		
		
		return mv;
		
	}

}
