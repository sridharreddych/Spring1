package com.hcl.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.movie.exception.MonthlySavingsException;
import com.hcl.movie.model.Offer;

@Service
public interface OfferService {

	List<Offer> getLoanOfferByMonthlySaving(Double montlymonthlysaving) throws MonthlySavingsException;
}
