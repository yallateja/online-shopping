package com.teja.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.teja.shoppingbackend.dao.CategoryDAO;
import com.teja.shoppingbackend.dto.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories=new ArrayList<>();
	
	static{
		
		Category category=new Category();
		category.setId(1);
		category.setName("Telivision");
		category.setDescription("desc telivision");
		category.setImageURL("Image Url");
		
		categories.add(category);
		
		category=new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("desc Mobile");
		category.setImageURL("Image Url mobile");
		
		categories.add(category);
		
		category=new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("desc Laptop");
		category.setImageURL("Image Url Laptop");
		
		categories.add(category);
	}
	
	@Override
	public List<Category> list() {
		
		return categories;
	}

	@Override
	public Category get(int id) {
		for(Category category:categories){
			
			if(category.getId()==id){
				
				return category;
			}
		}
		return null;
	}

}
