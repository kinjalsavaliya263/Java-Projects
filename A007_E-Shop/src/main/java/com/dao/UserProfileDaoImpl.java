package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.UserProfile;
@Transactional
@Repository
public class UserProfileDaoImpl implements UserProfileDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addOrUpdateUser(UserProfile u) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(u);
	}

	@Override
	public List<UserProfile> getallUsers() {
	
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from UserProfile").list();
	}

	@Override
	public UserProfile getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public UserProfile logincheck(UserProfile u) {
		
		Session session = sessionFactory.getCurrentSession();
		UserProfile profile =  (UserProfile) session.createQuery("from UserProfile p where p.email='"+u.getEmail()+"' and p.password='"+u.getPassword()+"'").uniqueResult();
		return profile;
	}

}
