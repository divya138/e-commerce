package com.example.ECommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ECommerce.exceptions.NoDataFoundException;
import com.example.ECommerce.model.Product;
import com.example.ECommerce.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findByNameContaining(String name) {

		return productRepository.findByNameContaining(name);
	}

	public List<Product> findByNameLike(String name) {

		return productRepository.findByNameLike(name);
	}

	public List<Product> findByNameStartingWith(String name) {

		return productRepository.findByNameStartingWith(name);
	}
	
}
