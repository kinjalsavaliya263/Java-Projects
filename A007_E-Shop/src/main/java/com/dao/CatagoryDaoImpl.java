package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Category;

@Repository
@Transactional
public class CatagoryDaoImpl implements CatagoryDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Category> getAllCategory() {
		
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Category").list();
	}

	@Override
	public Category getCatById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Category.class, id);
	}

	@Override
	public void addOrUpdateCate(Category cat) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cat);
		
	}

	@Override
	public void deleteCategory(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Category cat =  session.get(Category.class, id);
		session.delete(cat);
	}

		
}
