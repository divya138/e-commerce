package com.hcl.ecommerseapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.ecommerseapplication.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
