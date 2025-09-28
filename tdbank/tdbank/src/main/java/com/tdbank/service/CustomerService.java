package com.tdbank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tdbank.entity.Customer;
import com.tdbank.exception.ResourceNotFoundException;
import com.tdbank.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public Customer createCustomer(Customer customer) {
        return repo.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }

    public Customer getCustomerById(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("customer not found with id " + id));
    }

    public Customer updateCustomer(Long id, Customer newCustomer) {
        Customer existing = getCustomerById(id);
        existing.setName(newCustomer.getName());
        existing.setEmail(newCustomer.getEmail());
        existing.setPhone(newCustomer.getPhone());
        existing.setAddress(newCustomer.getAddress());
        return repo.save(existing);
    }

    public void deleteCustomer(Long id) {
        Customer existing = getCustomerById(id);
        repo.delete(existing);
    }
}
