package com.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="shopcart")
public class ShopCart {
		
	@Id
	int cartId;
	
	@JoinColumn(name="pid")
	@ManyToMany
	List<Product> products;
	
	int pQty;
	
	@JoinColumn(name ="uid")
	@ManyToMany
	List<UserProfile> userProfiles;
	
	

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getpQty() {
		return pQty;
	}

	public void setpQty(int pQty) {
		this.pQty = pQty;
	}

	public List<UserProfile> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(List<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}


	
	
	
	
	
	
}
