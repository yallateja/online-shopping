package com.teja.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.teja.shoppingbackend.dao.CategoryDAO;
import com.teja.shoppingbackend.dao.ProductDAO;
import com.teja.shoppingbackend.dto.Category;
import com.teja.shoppingbackend.dto.Product;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private static Product product;
	
	
	@BeforeClass
	public static void init(){
		
		context=new AnnotationConfigApplicationContext();
		context.scan("com.teja.shoppingbackend");
		context.refresh();
		
		productDAO=context.getBean("productDAO", ProductDAO.class);
	}
	
	@Test
	public void testAddProduct(){
		
//		product=new Product();
//		
//		product.setName("Oppo selfie");
//		product.setBrand("OPPO");
//		product.setDescription("Oppo mobile description");
//		product.setUnitPrice(25000);
//		product.setActive(true);
//		product.setCategoryId(3);
//		product.setSupplierId(3);
//		product=productDAO.get(6);
//		product.setActive(false);
		
		assertEquals("Some thing went wrong while adding", 2, productDAO.listActiveProductsByCategory(1).size());
		
		
	}

}
