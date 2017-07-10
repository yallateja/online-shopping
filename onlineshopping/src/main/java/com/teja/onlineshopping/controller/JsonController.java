package com.teja.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teja.shoppingbackend.dao.ProductDAO;
import com.teja.shoppingbackend.dto.Product;

@RestController
@RequestMapping("/json/data")
public class JsonController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/all/products")
	
	public List<Product> getAllProducts(){
		
		return productDAO.listActiveProducts();
		
		
	}
@RequestMapping("/category/{id}/products")
	
	public List<Product> getAllProductsById(@PathVariable int id){
		
		return productDAO.listActiveProductsByCategory(id);
		
		
	}

}
