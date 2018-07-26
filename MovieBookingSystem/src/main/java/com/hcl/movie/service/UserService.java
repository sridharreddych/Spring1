package com.hcl.movie.service;

import org.springframework.stereotype.Service;

import com.hcl.movie.model.Customer;

@Service
public interface UserService {

	Customer createUser(Customer customer);
}
