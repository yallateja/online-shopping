package com.teja.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.teja.shoppingbackend.dao.ProductDAO;
import com.teja.shoppingbackend.dto.Product;

@Transactional
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product get(int productId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Product.class, productId);
	}

	@Override
	public List<Product> list() {

		return sessionFactory.getCurrentSession().createQuery("from Product").getResultList();
	}

	@Override
	public boolean add(Product product) {
		try {

			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		product.setActive(false);
		try {

			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> listActiveProducts() {

		return sessionFactory.getCurrentSession().createQuery("from Product where active=:active", Product.class)
				.setParameter("active", true).getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {

		return sessionFactory.getCurrentSession()
				.createQuery("from Product where active=:active and categoryId=:categoryId", Product.class)
				.setParameter("active", true).setParameter("categoryId", categoryId).getResultList();

	}

	@Override
	public List<Product> getLatestActiveProducts(int counts) {

		return sessionFactory.getCurrentSession()
				.createQuery("from Product where active=:active order by id", Product.class)
				.setParameter("active", true).setFirstResult(0).setMaxResults(counts).getResultList();
	}

}
