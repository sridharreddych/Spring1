package com.ing.loan.service;

import java.util.List;

import com.ing.loan.exception.CustomerException;
import com.ing.loan.exception.LoanOfferException;
import com.ing.loan.exception.RecordNotFoundException;
import com.ing.loan.model.Customer;
import com.ing.loan.model.LoanOffer;



public interface CustomerLoanService {
	
	public LoanOffer saveLoanDetails(Integer loanid, Integer customerid)throws RecordNotFoundException;
	public LoanOffer addLoanOffer(LoanOffer loanOffer) throws LoanOfferException;
	public LoanOffer updateLoanOffer(LoanOffer loanOffer) throws LoanOfferException;
	public LoanOffer getLoanOffer(Integer offerId) throws LoanOfferException;
	public void deleteLoanOffer(Integer offerId) throws LoanOfferException;
	
	public List<LoanOffer> saveCustomerInformation(Customer customer);
	public Customer updateCustomerInformation(Customer customer);
	public Customer getCustomerInformation(Integer customerId) throws CustomerException;
	public void deleteCustomerInformation(Integer customerId);
	
	public List<LoanOffer> listOfAllOffersForParticularCustomer(Integer customerId) throws CustomerException ; 
}
