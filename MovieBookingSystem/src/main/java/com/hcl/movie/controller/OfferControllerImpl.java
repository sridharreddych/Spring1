package com.hcl.movie.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.movie.exception.ErrorDetail;
import com.hcl.movie.exception.MonthlySavingsException;
import com.hcl.movie.model.Offer;
import com.hcl.movie.service.OfferService;

@RestController
@CrossOrigin(maxAge = 3600, origins = "*")
public class OfferControllerImpl implements OfferController {

	/*** Property to hold auto-wired PromocampaignService instance. */
	@Autowired
	private OfferService offerService;
	
	@Autowired
	MessageSource messageSource;

	/*** Property to hold Logger instance and write to UI Service logs. */
	private static final Logger LOGGER = LoggerFactory.getLogger(OfferControllerImpl.class);

	@Override
	public ResponseEntity<List<Offer>> getLoanOfferByMonthlySaving(@NotNull Double monthlysaving) throws Exception {

		List<Offer> offerLst = new ArrayList<>();

		try {
			offerLst = offerService.getLoanOfferByMonthlySaving(monthlysaving);
		} catch (Exception e) {
			LOGGER.error("OfferControllerImpl.getLoanOfferByMonthlySaving(monthlysaving) = " + monthlysaving + ")");
			throw new Exception();
		}

		return new ResponseEntity<>(offerLst, HttpStatus.OK);
	}
	
	@ExceptionHandler(MonthlySavingsException.class)
	public ResponseEntity<ErrorDetail> handleDataAccessException(MonthlySavingsException ue) {
		String errorMessage = messageSource.getMessage("error.bad.input", new Object[] {},
				LocaleContextHolder.getLocale());
		ErrorDetail errorDetail = new ErrorDetail(HttpStatus.CONFLICT.name(), errorMessage);
		return new ResponseEntity<>(errorDetail, HttpStatus.CONFLICT);
	}
}
