package com.ing.loan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.loan.model.LoanOffer;

public interface LoanOfferRespsitory extends JpaRepository<LoanOffer, Integer>{
	public LoanOffer findByMinimumSalaryEligibity(Double minimumSalaryEligibity);
	
	public List<LoanOffer> findByMinimumSalaryEligibityLessThanEqual(Double minimumSalaryEligibity);
}
