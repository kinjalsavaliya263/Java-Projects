package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserProfileDao;
import com.model.UserProfile;

@Service
public class UserProfileServiceImpl implements UserProfileService {
	@Autowired
	UserProfileDao userProfileDao;
	
	@Override
	public void addOrUpdateUser(UserProfile u) {
		userProfileDao.addOrUpdateUser(u);
	}

	@Override
	public List<UserProfile> getallUsers() {
		// TODO Auto-generated method stub
		return userProfileDao.getallUsers();
	}

	@Override
	public UserProfile getUserById(int id) {
		// TODO Auto-generated method stub
		return userProfileDao.getUserById(id);
	}

	@Override
	public void deleteUser(int id) {
		userProfileDao.deleteUser(id);
	}

	@Override
	public UserProfile logincheck(UserProfile u) {
		
		return userProfileDao.logincheck(u);
	}

}
