package com.tdbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tdbank.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
