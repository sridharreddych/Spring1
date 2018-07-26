package com.ing.loan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.loan.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
