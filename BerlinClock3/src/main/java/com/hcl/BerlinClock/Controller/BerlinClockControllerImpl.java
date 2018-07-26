package com.hcl.BerlinClock.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.BerlinClock.Service.BerlinClockServiceImpl;
import com.hcl.BerlinClock.Service.BerlinclockService;

@RestController
@RequestMapping(value="/berlinClock")
public class BerlinClockControllerImpl implements BerlinClockController{
	
	@Autowired
	BerlinclockService berlinclockService=new BerlinClockServiceImpl();

	
	@GetMapping("/convert/{input}")
	public String[] convertToBerlinTime(@PathVariable("input") String string) {
		return berlinclockService.convertToBerlinTime(string);
	}

}
