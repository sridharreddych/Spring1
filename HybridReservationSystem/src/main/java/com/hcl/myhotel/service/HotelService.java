package com.hcl.myhotel.service;

import org.springframework.data.domain.Page;

import com.hcl.myhotel.domain.Hotel;


/**
 * @author Sridhar reddy
 *Hotel Service Interface
 */
public interface HotelService {

	public Hotel createHotel(Hotel hotel);
	public Hotel getHotel(long id);
	public Hotel updateHotel(Hotel hotel);
	public void deleteHotel(Long id);
	public Page<Hotel> getAllHotels(Integer page, Integer size);
}