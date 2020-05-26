package com.example.ECommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ECommerce.model.Product;
@Repository

public interface ProductRepository extends JpaRepository<Product,Integer> {
	
	List<Product> findByNameLike(String name);
	List<Product> findByNameStartingWith(String name);
	List<Product> findByNameContaining(String name);

}
