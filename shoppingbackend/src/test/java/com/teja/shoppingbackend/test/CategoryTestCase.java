package com.teja.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.teja.shoppingbackend.dao.CategoryDAO;
import com.teja.shoppingbackend.dto.Category;

public class CategoryTestCase {

	
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private static Category category;
	
	
	@BeforeClass
	public static void init(){
		
		context=new AnnotationConfigApplicationContext();
		context.scan("com.teja.shoppingbackend");
		context.refresh();
		
		categoryDAO=context.getBean("categoryDAO", CategoryDAO.class);
	}
	
	@Test
	public void testCategory(){
		
		category =new Category();
		category.setName("Computer");
		category.setDescription("desc Computer");
		category.setImageURL("Image Url Computer");
		//category.setIs_active(false);
		
		assertEquals("Succesfully added", true,categoryDAO.add(category) );
	}
	
	/*@Test
	public void testGetCategory(){
		category =categoryDAO.get(2);
		
		
		assertEquals("Succesfully fetched a single category", "Mobile",category.getName() );
	}
	*/
	
	
	/*@Test
	public void updateCategory(){
		
		category =categoryDAO.get(2);
		category.setName("Laptop");
		assertEquals("Succesfully updated",true,categoryDAO.update(category) );
	}*/
	
	/*@Test
	public void getListCategory(){
		
		assertEquals("Succesfully retrived",2,categoryDAO.list().size());
		
	}*/
}
