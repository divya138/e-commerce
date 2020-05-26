package com.example.ECommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.ECommerce.model.Product;
import com.example.ECommerce.service.ProductService;



@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("products1/{name}")
	public ResponseEntity<List<Product>> findByNameContaining(@PathVariable String name) {
		System.out.println(name);
		List<Product> product=productService.findByNameContaining(name);
		 return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
	}

	@GetMapping("products2/{name}")
	public ResponseEntity<List<Product>> findByNameLike(@PathVariable String name) {
		System.out.println(name);
		List<Product> product= productService.findByNameLike(name);
		 return new ResponseEntity<List<Product>>(product, HttpStatus.OK);

	}

	@GetMapping("products3/{name}")
	public ResponseEntity<List<Product>> findByNameStartingWith(@PathVariable String name) {
		List<Product> product= productService.findByNameStartingWith(name);
		 return new ResponseEntity<List<Product>>(product, HttpStatus.OK);

	}

}
