package com.ecommerceapplication.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerceapplication.model.Account;


public interface AccountRepository extends JpaRepository<Account, Long>{

}
