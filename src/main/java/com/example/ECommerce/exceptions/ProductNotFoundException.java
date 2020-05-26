package com.example.ECommerce.exceptions;

public class ProductNotFoundException extends RuntimeException {
	public ProductNotFoundException(int pId) {
		 super(String.format("product with pId %d not found", pId));
	}

}
