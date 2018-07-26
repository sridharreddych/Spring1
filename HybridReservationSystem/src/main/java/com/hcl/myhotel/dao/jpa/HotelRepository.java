package com.hcl.myhotel.dao.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hcl.myhotel.domain.Hotel;


/**
 * @author Sridhar reddy
 * This is Repository to connect to mysql
 */
public interface HotelRepository extends PagingAndSortingRepository<Hotel, Long> {
    Hotel findHotelByCity(String city);
    Page findAll(Pageable pageable);
	boolean existsById(Long id);
}
