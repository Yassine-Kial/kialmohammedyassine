package com.example.kialmohammedyassine.service;


import com.example.kialmohammedyassine.entity.Customer;
import com.example.kialmohammedyassine.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;


    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return this.customerRepository.findById(id).get();
    }

    public void addCustomer(Customer customer) {
        this.customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        this.customerRepository.deleteById(id);
    }

    public void updateCustomer(Long id,Customer customer) {
        this.customerRepository.findById(id).map(c-> {
                    c.setId(id);
                    c.setName(customer.getName());
                    c.setAddress(customer.getAddress());
                    return this.customerRepository.save(c);
                }
        );
    }
}
