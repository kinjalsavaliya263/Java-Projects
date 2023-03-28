package com.dao;

import java.util.List;

import com.model.Product;

public interface ProductDao {

	public List<Product> getAllProduct();
	public Product getProductById(int id);
	public void addOrUpdateProduct(Product pro);
	public void deleteProduct(int id);
}
