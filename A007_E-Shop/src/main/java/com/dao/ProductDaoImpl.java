package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Product> getAllProduct() {
		
		Session s  =sessionFactory.getCurrentSession();
		return s.createQuery("from Product").list();
	}

	@Override
	public Product getProductById(int id) {
		Session s  =sessionFactory.getCurrentSession();
		return s.get(Product.class, id);
	}

	@Override
	public void addOrUpdateProduct(Product pro) {
		
		Session s  =sessionFactory.getCurrentSession();
		s.saveOrUpdate(pro);

	}

	@Override
	public void deleteProduct(int id) {
		Session s  =sessionFactory.getCurrentSession();
		Product p = s.get(Product.class, id);
		s.delete(p);

	}

}
