package com.ecommerceapplication.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerceapplication.model.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>{

}
