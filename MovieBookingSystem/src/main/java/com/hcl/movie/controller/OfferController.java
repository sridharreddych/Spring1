package com.hcl.movie.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hcl.movie.model.Offer;

public interface OfferController {

	@RequestMapping(value = "/loanoffer", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<List<Offer>> getLoanOfferByMonthlySaving(@PathVariable("monthlysaving") Double monthlysaving)
			throws Exception;

}
