package com.dao;

import java.util.List;

import com.model.Category;

public interface CatagoryDao {
	public List<Category> getAllCategory();
	public Category getCatById(int id);
	public void addOrUpdateCate(Category cat);
	public void deleteCategory(int id);
}
