package com.teja.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.teja.shoppingbackend.dao.CategoryDAO;
import com.teja.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> list() {
		
		Query query=sessionFactory.getCurrentSession().createQuery("from Category where active=:active");
		query.setParameter("active", true);

		return query.getResultList();
	}

	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, id);
	}

	@Override

	public boolean add(Category category) {
		try {

			sessionFactory.getCurrentSession().save(category);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

	}

	@Override
	public boolean update(Category category) {

		try {

			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

	@Override
	public boolean delete(Category category) {
		
		category.setIs_active(false);
		try {

			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}

}
