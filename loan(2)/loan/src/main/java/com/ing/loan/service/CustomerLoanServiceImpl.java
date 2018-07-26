package com.ing.loan.service;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.loan.constants.LoanConstants;
import com.ing.loan.dao.CustomerLoanDetailsRepository;
import com.ing.loan.dao.CustomerRepository;
import com.ing.loan.dao.LoanOfferRespsitory;
import com.ing.loan.exception.CustomerException;
import com.ing.loan.exception.LoanOfferException;
import com.ing.loan.exception.RecordNotFoundException;
import com.ing.loan.model.Customer;
import com.ing.loan.model.CustomerLoanDetails;
import com.ing.loan.model.LoanOffer;

@Service
public class CustomerLoanServiceImpl implements CustomerLoanService{
	
	private static final Logger logger = Logger.getLogger(CustomerLoanServiceImpl.class);
	
	@Autowired
	private LoanOfferRespsitory loanOfferRespsitory;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerLoanDetailsRepository customerLoanDetailsRepository;

	@Override
	public LoanOffer saveLoanDetails(Integer loanid, Integer customerid) throws RecordNotFoundException{
		logger.info(CustomerLoanServiceImpl.class.getName()+" - "+Thread.currentThread().getStackTrace()[1].getMethodName()+"()-"+LoanConstants.ENTRY);
		LoanOffer loanOffer = getLoanOfferById(loanid);
		Customer customerDetails = getCustomerById(customerid);
		if(loanOffer == null || customerDetails == null){
			if(loanOffer == null && customerDetails == null)
				throw new RecordNotFoundException("LoanId and CustomerId is not found!");
			else if(loanOffer ==null)
				throw new RecordNotFoundException("LoanId not found!");
			else 
				throw new RecordNotFoundException("customerId not found!");
				
		}
		CustomerLoanDetails customerLoanDetails = new CustomerLoanDetails();
		customerLoanDetails.setCustomer(customerDetails);
		customerLoanDetails.setLoanOffer(loanOffer);
		customerLoanDetailsRepository.save(customerLoanDetails);
		logger.info(CustomerLoanServiceImpl.class.getName()+" - "+Thread.currentThread().getStackTrace()[1].getMethodName()+"()-"+LoanConstants.EXIT);
		return loanOffer;
	}
	
	private LoanOffer getLoanOfferById(Integer loanid){
		logger.info(CustomerLoanServiceImpl.class.getName()+" - "+Thread.currentThread().getStackTrace()[1].getMethodName()+"()-"+LoanConstants.ENTRY);
		LoanOffer loanOffer = null;
		Optional<LoanOffer> optional = loanOfferRespsitory.findById(loanid);
		if(optional.isPresent()){
			loanOffer = optional.get();
		}
		logger.info(CustomerLoanServiceImpl.class.getName()+" - "+Thread.currentThread().getStackTrace()[1].getMethodName()+"()-"+LoanConstants.EXIT);
		return loanOffer; 
	}
	
	private Customer getCustomerById(Integer customerId){
		logger.info(CustomerLoanServiceImpl.class.getName()+" - "+Thread.currentThread().getStackTrace()[1].getMethodName()+"()-"+LoanConstants.ENTRY);
		Customer customer = null;		
		Optional<Customer> optional = customerRepository.findById(customerId);
		logger.info("Customer is present="+optional.isPresent());
		if(optional.isPresent()){
			customer = optional.get();
		}
		logger.info(CustomerLoanServiceImpl.class.getName()+" - "+Thread.currentThread().getStackTrace()[1].getMethodName()+"()-"+LoanConstants.EXIT);
		return customer;
	}
	
	/*Jaison Code Starts*/
	@Override
	public LoanOffer addLoanOffer(LoanOffer loanOffer) throws LoanOfferException {
		logger.info("addLoanOffer Service : Start");
		if (loanOfferRespsitory.findByMinimumSalaryEligibity(loanOffer.getMinimumSalaryEligibity()) != null)
			throw new LoanOfferException("Offer already exists for the the given Salary eligibility");
		return loanOfferRespsitory.save(loanOffer);
	}

	@Override
	public LoanOffer updateLoanOffer(LoanOffer loanOffer) throws LoanOfferException {
		logger.info("updateLoanOffer Service : Start");

		if (!loanOfferRespsitory.existsById(loanOffer.getLoanOfferId()))
			throw new LoanOfferException("Offer not exists");

		return loanOfferRespsitory.save(loanOffer);
	}

	@Override
	public LoanOffer getLoanOffer(Integer offerId) throws LoanOfferException {
		logger.info("getLoanOffer Service : Start");

		Optional<LoanOffer> optionalOffer = loanOfferRespsitory.findById(offerId);
		if (!optionalOffer.isPresent())
			throw new LoanOfferException("Offer not available");
		return optionalOffer.get();
	}

	@Override
	public void deleteLoanOffer(Integer offerId) throws LoanOfferException {

		logger.info("deleteLoanOffer Service : Start");

		if (!loanOfferRespsitory.existsById(offerId))
			throw new LoanOfferException("Offer not exists");
		loanOfferRespsitory.deleteById(offerId);
	}
	/*Jaison Code Ends*/

	/*manjunath code Starts*/
	@Override
	public List<LoanOffer> saveCustomerInformation(Customer customer) {
		
		logger.info("ENTRY----- to CustomerLoanServiceImpl with saveCustomerInformation()");	
		
	     customerRepository.save(customer);	
	     Double minimumSalaryEligibility = customer.getMonthlyIncome() -customer.getMonthlyExpenditure();
	     logger.info("minimumSalaryEligibility = " +minimumSalaryEligibility);	     
	     return getLoanOffers(minimumSalaryEligibility);
	}
	
	
	@Override
	public Customer updateCustomerInformation(Customer customer) {
		
		logger.info("ENTRY----- to CustomerLoanServiceImpl with saveCustomerInformation()");		
		return  customerRepository.save(customer);			 
		
	}
	

	@Override
	public Customer getCustomerInformation(Integer customerId) throws CustomerException {
		
		logger.info("ENTRY----- to CustomerLoanServiceImpl with getCustomerInformation()");		
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);	
		if(optionalCustomer.isPresent()) {
			return optionalCustomer.get();
		}
		
		throw new CustomerException("Customer not Available");
			
	}
	

	@Override
	public void deleteCustomerInformation(Integer customerId) {
		
		logger.info("ENTRY----- to CustomerLoanServiceImpl with deleteCustomerInformation()");			
		 customerRepository.deleteById(customerId);			 
		
	}
	
	private List<LoanOffer> getLoanOffers(Double minimumSalaryEligibility){
		logger.info("ENTRY--- CustomerLoanServiceImpl----  getLoanOffers");
		
		return loanOfferRespsitory.findByMinimumSalaryEligibityLessThanEqual(minimumSalaryEligibility);		
		
	}

	@Override
	public List<LoanOffer> listOfAllOffersForParticularCustomer(Integer customerId) throws CustomerException {
		logger.info("ENTRY--- CustomerLoanServiceImpl---- listOfAllOffersForParticularCustomer()");
		Optional<Customer> optional   =customerRepository.findById(customerId);
		Double minimumSalaryEligibility;
		if(optional.isPresent()) {
			Customer customer =optional.get();
			minimumSalaryEligibility =customer.getMonthlyIncome()- customer.getMonthlyExpenditure();
			
		 logger.info("minimumSalaryEligibility :" +minimumSalaryEligibility);
				
				 return loanOfferRespsitory.findByMinimumSalaryEligibityLessThanEqual(minimumSalaryEligibility);				
		}
			 else {
					throw new CustomerException("Not having Offers");
				}
		
		
		  	
	}
	/*manjunath code Ends*/
}
