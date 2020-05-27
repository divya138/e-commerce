package com.hcl.ecommerseapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.ecommerseapplication.model.Orders;

public interface OrderRepository extends JpaRepository<Orders,Integer>{

}
