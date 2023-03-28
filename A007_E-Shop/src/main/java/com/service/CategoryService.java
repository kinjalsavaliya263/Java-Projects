package com.service;

import java.util.List;

import com.model.Category;

public interface CategoryService {
		
	public List<Category> getAllCategory();
	public Category getCatById(int id);
	public void addOrUpdateCate(Category cat);
	public void deleteCategory(int id);
}
