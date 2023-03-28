package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CatagoryDao;
import com.model.Category;
@Service
public class CatagoryServiceImpl implements CategoryService {

	@Autowired
	CatagoryDao catagoryDao;
	
	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return catagoryDao.getAllCategory();
	}

	@Override
	public Category getCatById(int id) {
		// TODO Auto-generated method stub
		return catagoryDao.getCatById(id);
	}

	@Override
	public void addOrUpdateCate(Category cat) {
		catagoryDao.addOrUpdateCate(cat);
	}

	@Override
	public void deleteCategory(int id) {
		catagoryDao.deleteCategory(id);
	}

}
