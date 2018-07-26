package com.ing.loan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.loan.model.CustomerLoanDetails;

public interface CustomerLoanDetailsRepository extends JpaRepository<CustomerLoanDetails, Integer>{

}
