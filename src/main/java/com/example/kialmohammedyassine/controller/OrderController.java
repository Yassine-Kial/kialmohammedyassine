package com.example.kialmohammedyassine.controller;


import com.example.kialmohammedyassine.entity.Customer;
import com.example.kialmohammedyassine.entity.Order;
import com.example.kialmohammedyassine.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }



    @GetMapping("/getAll")
    public List<Order> getAllOrders() {
        return this.orderService.getAllOrders();
    }


    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return this.orderService.getOrderById(id);
    }




    @PostMapping("/add")
    public void addOrder(@RequestBody Order order) {
        this.orderService.addOrder(order);
    }



    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable Long id) {
        this.orderService.deleteOrder(id);
    }


    @PutMapping("/update/{id}")
    public void updateOrder(@PathVariable Long id, @RequestBody Order order) {
        this.orderService.updateCustomer(id,order);
    }









}
