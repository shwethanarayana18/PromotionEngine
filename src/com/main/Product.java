package com.main;

public class Product {
	public String id;
	public int occuranceOfIdInCart;

	public Product(String id, int occuranceOfIdInCart) {
		this.id = id;
		this.occuranceOfIdInCart=occuranceOfIdInCart;
	}

	public int getOccuranceOfIdInCart() {
		return occuranceOfIdInCart;
	}

	public void setOccuranceOfIdInCart(int occuranceOfIdInCart) {
		this.occuranceOfIdInCart = occuranceOfIdInCart;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
