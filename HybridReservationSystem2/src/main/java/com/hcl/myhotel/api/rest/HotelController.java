package com.hcl.myhotel.api.rest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.myhotel.constants.HotelConstants;
import com.hcl.myhotel.domain.Hotel;
import com.hcl.myhotel.exception.DataFormatException;
import com.hcl.myhotel.exception.HotelDetailsNotFoundException;
import com.hcl.myhotel.service.HotelServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author Sridhar reddy
 * This is Hotel Controller class which routes all requests to Service Layer
 */
@RestController
@RequestMapping(value = "/hotel")
@Api(tags = { "hotels" })
public class HotelController extends AbstractRestHandler {

	private static final Logger logger = Logger.getLogger(HotelController.class);

	@Autowired
	private HotelServiceImpl hotelService;

	@RequestMapping(value = "/book/your/hotel", method = RequestMethod.POST, consumes = { "application/json",
			"application/xml" }, produces = { "application/json", "application/xml" })
	@ApiOperation(value = "Creates hotel details in the table.", notes = "Returns the URL of the new resource in the Location header.")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		logger.info("HotelController:createHotel:Start");
		Hotel createdHotel = hotelService.createHotel(hotel);
		//response.setHeader("Location", request.getRequestURL().append("/").append(createdHotel.getId()).toString());
		logger.info("HotelController:createHotel:end");
		return new ResponseEntity<>(createdHotel, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/listof/allhotels", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	@ApiOperation(value = "Get List of all hotel using pagination.", notes = "You can provide maximum page number up to 100")
	public ResponseEntity<Page<Hotel>> getAllHotel(
			@ApiParam(value = "The page number", required = true) @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
			@ApiParam(value = "Tha page size", required = true) @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size) {

		logger.info(HotelController.class.getName() + " - " + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "()-" + HotelConstants.ENTRY);
		Page<Hotel> pageHotel = hotelService.getAllHotels(page, size);
		logger.info(HotelController.class.getName() + " - " + Thread.currentThread().getStackTrace()[1].getMethodName()
				+ "()-" + HotelConstants.EXIT);
		return new ResponseEntity<Page<Hotel>>(pageHotel, HttpStatus.OK);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@ApiOperation(value = "Get single hotel details.", notes = "Here you should provide valid hotel id")
	public ResponseEntity<Hotel> getHotel(
			@ApiParam(value = "The ID of the hotel.", required = true) @PathVariable("id") Long id) throws HotelDetailsNotFoundException {
		logger.info("HotelController:getHotel:Start");
		Hotel hotel = hotelService.getHotel(id);
		IsResourceExist(hotel);
		return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = { "application/json",
			"application/xml" }, produces = { "application/json", "application/xml" })
	@ApiOperation(value = "Update a hotel with corresponding hotel id.", notes = "You have to provide a valid hotel ID in both url and body.")
	public ResponseEntity<Hotel> updateHotel(
			@ApiParam(value = "This is the ID of the existing hotel.", required = true) @PathVariable("id") Long id,
			@RequestBody Hotel hotel) throws HotelDetailsNotFoundException {
		IsResourceExist(this.hotelService.getHotel(id));
		if (id != hotel.getId()) {
			throw new DataFormatException("ID is not matching!!");
		}
		return new ResponseEntity<>(hotelService.updateHotel(hotel), HttpStatus.ACCEPTED);

	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = { "application/json",
			"application/xml" })
	@ApiOperation(value = "Delete a hotel by id.", notes = "You have to provide a valid hotel id and once deleted you cannot get it back")
	public ResponseEntity<String> deleteHotel(
			@ApiParam(value = "The ID of the existing hotel.", required = true) @PathVariable("id") Long id) throws HotelDetailsNotFoundException{
		IsResourceExist(this.hotelService.getHotel(id));
		hotelService.deleteHotel(id);
		return new ResponseEntity<>("Record Deleted",HttpStatus.ACCEPTED);
		
	}
}
