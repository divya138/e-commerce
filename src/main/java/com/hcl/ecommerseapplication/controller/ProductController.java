package com.hcl.ecommerseapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerseapplication.dto.TransferDto;
import com.hcl.ecommerseapplication.model.Product;
import com.hcl.ecommerseapplication.model.Transaction;
import com.hcl.ecommerseapplication.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	@PostMapping("/product")
	public ResponseEntity<Product> buyProduct(@RequestParam String email,@RequestParam int productId,@RequestParam int categoryId,@RequestBody TransferDto transferDto){
		return productService.buyProduct(email, productId, categoryId, transferDto);
		
	}

}
