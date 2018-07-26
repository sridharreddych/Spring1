package com.hcl.movie.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.movie.dao.LoanEligibilityDao;
import com.hcl.movie.exception.MonthlySavingsException;
import com.hcl.movie.model.Offer;

@Service
public class OfferServiceImpl implements OfferService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OfferServiceImpl.class);

	@Autowired
	LoanEligibilityDao loanEligibilityDao;

	@SuppressWarnings("unchecked")
	@Override
	public List<Offer> getLoanOfferByMonthlySaving(Double monthlysaving) throws MonthlySavingsException {

		List<Offer> offers= new ArrayList<>();
		
		try {
			
				if(monthlysaving < 10000){
					throw new MonthlySavingsException(
							"savings amount less than 10000 will not be eligible for Loan" + monthlysaving);
				}
				else {
					offers = loanEligibilityDao.findAllByMonthlySal(monthlysaving);
				}		
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	return offers;
	}

}
