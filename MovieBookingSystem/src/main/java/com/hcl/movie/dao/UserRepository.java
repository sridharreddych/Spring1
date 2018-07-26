package com.hcl.movie.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.movie.model.Customer;

public interface UserRepository extends JpaRepository<Customer, Integer> {

	Optional<Customer> findById(Integer id);
}
