package com.teja.shoppingbackend.dao;

import java.util.List;

import com.teja.shoppingbackend.dto.Category;

public interface CategoryDAO {

	
	List<Category> list();

	Category get(int id);
}
