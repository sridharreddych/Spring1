package com.ing.loan.controller;

import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ing.loan.constants.LoanConstants;
import com.ing.loan.dao.LoanOfferRespsitory;
import com.ing.loan.exception.CustomerException;
import com.ing.loan.exception.LoanOfferException;
import com.ing.loan.exception.RecordNotFoundException;
import com.ing.loan.model.Customer;
import com.ing.loan.model.LoanOffer;
import com.ing.loan.service.CustomerLoanService;

@RestController
@RequestMapping("/loan")
public class CustomerLoanController {
	private static final Logger logger = Logger.getLogger(CustomerLoanController.class);
	
	@Autowired
	private CustomerLoanService customerLoanService;
	
	@Autowired
	private LoanOfferRespsitory loanOfferRespsitory;
	
	@GetMapping("/save/selected/loan")	
	public ResponseEntity<LoanOffer> saveLoanDetails(@RequestParam(name="loanid",required=true) Integer loanid, @RequestParam(name="customerid",required=true) Integer customerid) throws RecordNotFoundException{
		logger.info(CustomerLoanController.class.getName()+" - "+Thread.currentThread().getStackTrace()[1].getMethodName()+"()-"+LoanConstants.ENTRY);
		logger.info("loanid="+loanid);
		logger.info("customerid="+customerid);
		LoanOffer loanOffer = customerLoanService.saveLoanDetails(loanid, customerid);
		logger.info(CustomerLoanController.class.getName()+" - "+Thread.currentThread().getStackTrace()[1].getMethodName()+"()-"+LoanConstants.EXIT);
		return new ResponseEntity<LoanOffer>(loanOffer,HttpStatus.OK);
	}
	
	/*Jaison Code STARTS*/
	@RequestMapping(value = "/loanoffer", method = RequestMethod.POST)
	public ResponseEntity<LoanOffer> addLoanOffer(@Valid @RequestBody LoanOffer loanOffer) throws LoanOfferException {
		logger.info("CustomerLoanController:addLoanOffer :Start");
		return new ResponseEntity<>(customerLoanService.addLoanOffer(loanOffer), HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/loanoffer", method = RequestMethod.PUT)
	public ResponseEntity<LoanOffer> updateLoanOffer(@RequestBody LoanOffer loanOffer) throws LoanOfferException {
		logger.info("CustomerLoanController:updateLoanOffer :Start");
		return new ResponseEntity<>(customerLoanService.updateLoanOffer(loanOffer), HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/loanoffer/{offerId}", method = RequestMethod.GET)
	public ResponseEntity<LoanOffer> getLoanOffer(@PathVariable(name = "offerId") Integer offerId)
			throws LoanOfferException {
		logger.info("CustomerLoanController:getLoanOffer :Start");
		return new ResponseEntity<>(customerLoanService.getLoanOffer(offerId), HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/loanoffer/{offerId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteLoanOffer(@PathVariable(name = "offerId") Integer offerId)
			throws LoanOfferException {
		logger.info("CustomerLoanController:deleteLoanOffer :Start");
		customerLoanService.deleteLoanOffer(offerId);
		return new ResponseEntity<>("Record Deleted", HttpStatus.ACCEPTED);
	}
	/*Jaison Code ENDS*/
	
	/*manjunath code START*/
	/**
	 * This method is for 
	 * Create a new Customer in database OR
	 * Save Customer Details into Database
	*/
	@PostMapping("/createCustomer")
	public ResponseEntity<List<LoanOffer>> createCustomerInformation (@Valid @RequestBody Customer customer )  {
		logger.info(CustomerLoanController.class.getName()+" - "+Thread.currentThread().getStackTrace()[1].getMethodName()+"()-"+LoanConstants.ENTRY);
		
		List<LoanOffer>	 loanOffers =customerLoanService.saveCustomerInformation(customer);
	 
		logger.info(CustomerLoanController.class.getName()+" - "+Thread.currentThread().getStackTrace()[1].getMethodName()+"()-"+LoanConstants.EXIT);
		return new ResponseEntity<>(loanOffers, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCustomer/{cutomerId}")
	public ResponseEntity<Customer> deleteCustomerInformation (@PathVariable("cutomerId") Integer cutomerId)  {
		logger.info(CustomerLoanController.class.getName()+" - "+Thread.currentThread().getStackTrace()[1].getMethodName()+"()-"+LoanConstants.ENTRY);
		
		customerLoanService.deleteCustomerInformation(cutomerId);
		
		logger.info(CustomerLoanController.class.getName()+" - "+Thread.currentThread().getStackTrace()[1].getMethodName()+"()-"+LoanConstants.EXIT);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<Customer> updateCustomerInformation ( @RequestBody Customer customer )  {
		logger.info(CustomerLoanController.class.getName()+" - "+Thread.currentThread().getStackTrace()[1].getMethodName()+"()-"+LoanConstants.ENTRY);
		
		Customer cust=   customerLoanService.updateCustomerInformation(customer);
		
		logger.info(CustomerLoanController.class.getName()+" - "+Thread.currentThread().getStackTrace()[1].getMethodName()+"()-"+LoanConstants.EXIT);
		return new ResponseEntity<>(cust, HttpStatus.OK);
	}
	
	@GetMapping("/getCustomer/{customerId}")
	public ResponseEntity<Customer> getCustomerInformation (@PathVariable("customerId") Integer customerId ) throws CustomerException  {
		logger.info(CustomerLoanController.class.getName()+" - "+Thread.currentThread().getStackTrace()[1].getMethodName()+"()-"+LoanConstants.ENTRY);
		Customer customer=   customerLoanService.getCustomerInformation(customerId);
		if( customerId !=  customer.getCustomerId()) {
			throw new CustomerException("customerId not a valid");
		}
		logger.info(CustomerLoanController.class.getName()+" - "+Thread.currentThread().getStackTrace()[1].getMethodName()+"()-"+LoanConstants.EXIT);		
		return  new ResponseEntity<>( customer , HttpStatus.OK);
	
	}
	
	@GetMapping("/getCustomerOffer/{customerId}")
	public ResponseEntity<List<LoanOffer>> getCustomerListOfOffers (@PathVariable("customerId") Integer customerId ) throws CustomerException  {
		logger.info(CustomerLoanController.class.getName()+" - "+Thread.currentThread().getStackTrace()[1].getMethodName()+"()-"+LoanConstants.ENTRY);
		Customer custId =customerLoanService.getCustomerInformation(customerId) ;
		if(customerId != custId.getCustomerId()  ) {
			throw new CustomerException("customerId not a valid");
		}
		List<LoanOffer> loanOffer =  customerLoanService.listOfAllOffersForParticularCustomer(customerId);
		
		
		if(loanOffer == null) {
			throw new CustomerException("Offer List Not Available");
		}		
		logger.info(CustomerLoanController.class.getName()+" - "+Thread.currentThread().getStackTrace()[1].getMethodName()+"()-"+LoanConstants.EXIT);
		return  new ResponseEntity<>( loanOffer , HttpStatus.OK);	
	}
	/*manjunath code END*/
}
