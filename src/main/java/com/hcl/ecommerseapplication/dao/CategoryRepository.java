package com.hcl.ecommerseapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.ecommerseapplication.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
