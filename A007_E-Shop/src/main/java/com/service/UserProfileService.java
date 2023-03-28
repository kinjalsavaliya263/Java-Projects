package com.service;

import java.util.List;

import com.model.UserProfile;

public interface UserProfileService {
	
	public void addOrUpdateUser(UserProfile u);
	public List<UserProfile> getallUsers();
	public UserProfile getUserById(int id);
	public void deleteUser(int id);
	public UserProfile logincheck(UserProfile u);
}
