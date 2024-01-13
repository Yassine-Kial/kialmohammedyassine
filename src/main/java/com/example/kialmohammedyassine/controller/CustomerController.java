package com.example.kialmohammedyassine.controller;


import com.example.kialmohammedyassine.entity.Customer;
import com.example.kialmohammedyassine.entity.Order;
import com.example.kialmohammedyassine.service.CustomerService;
import com.example.kialmohammedyassine.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final OrderService orderService;

    @Autowired
    public CustomerController(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }


    @GetMapping("/getAll")
    public List<Customer> getAllCustomers() {
        return this.customerService.getAllCustomers();
    }


    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return this.customerService.getCustomerById(id);
    }


    @PostMapping("/add")
    public void addCustomer(@RequestBody Customer customer) {
        this.customerService.addCustomer(customer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        this.customerService.deleteCustomer(id);
    }

    @PutMapping("/update/{id}")
    public void updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        this.customerService.updateCustomer(id,customer);
    }


    @PostMapping("/assignOrderToCustomer/{id}/{orderId}")
    public void assignOrderToCustomer(@PathVariable Long id, @PathVariable Long orderId) {
        Customer customer  = this.customerService.getCustomerById(id);
        Order order = this.orderService.getOrderById(orderId);
        customer.addOrder(order);
        this.orderService.updateOrder(order.getId(),order);

    }


}
