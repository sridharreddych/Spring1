package com.hcl.movie.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.movie.model.Customer;
import com.hcl.movie.service.UserService;

@RestController
@CrossOrigin(maxAge = 3600, origins = "*")
public class UserController {

	@Autowired
	private UserService userService;
	
	/*** Property to hold Logger instance and write to UI Service logs. */
	private static final Logger LOGGER = LoggerFactory.getLogger(OfferControllerImpl.class);
	
	
	@PostMapping(value="/create")
    public ResponseEntity<Void> createEmployee(@RequestBody Customer customer){
		
		LOGGER.error("creating user");
        
		try {
			userService.createUser(customer);
		} catch (Exception e) {
			LOGGER.error("Exception in user creation");
			
		}
		
        
        HttpHeaders headers = new HttpHeaders();
       
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
	@GetMapping("/get")
	public @ResponseBody Customer getData() {
		Customer customer = new Customer();
		customer.setDob(new Date());
		return customer;
	}
	
	 
}
