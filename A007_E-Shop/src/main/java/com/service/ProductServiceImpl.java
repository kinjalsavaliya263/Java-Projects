package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ProductDao;
import com.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;
	
	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productDao.getAllProduct();
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return productDao.getProductById(id);
	}

	@Override
	public void addOrUpdateProduct(Product pro) {
		productDao.addOrUpdateProduct(pro);

	}

	@Override
	public void deleteProduct(int id) {
		productDao.deleteProduct(id);

	}

}
