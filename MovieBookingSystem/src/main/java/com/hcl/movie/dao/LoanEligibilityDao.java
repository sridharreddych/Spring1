package com.hcl.movie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.movie.model.Offer;

@Repository
public interface LoanEligibilityDao<T> extends CrudRepository<Offer, Integer> {

	
	@Query("SELECT o FROM Offer o where o.monthlySaving>10000 and o.monthlySaving < :monthlySal")
	List<Offer> findAllByMonthlySal(@Param("monthlySal") Double monthlySal);

}
