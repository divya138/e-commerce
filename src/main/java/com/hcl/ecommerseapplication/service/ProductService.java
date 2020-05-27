package com.hcl.ecommerseapplication.service;

import org.springframework.http.ResponseEntity;

import com.hcl.ecommerseapplication.dto.TransferDto;
import com.hcl.ecommerseapplication.model.Product;



public interface ProductService {
	
	public ResponseEntity<Product> buyProduct(String username,int productId,int categoryId,TransferDto transferDto);

}
