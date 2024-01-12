package com.example.kialmohammedyassine.service;

import com.example.kialmohammedyassine.entity.Customer;
import com.example.kialmohammedyassine.entity.Order;
import com.example.kialmohammedyassine.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;


    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public List<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return this.orderRepository.findById(id).get();
    }


    public void addOrder(Order order) {
        this.orderRepository.save(order);
    }


    public void deleteOrder(Long id) {
        this.orderRepository.deleteById(id);
    }

    public void updateCustomer(Long id, Order order) {

        this.orderRepository.findById(id).map(o-> {
                    o.setId(id);
                    o.setDate(order.getDate());
                    o.setStatus(order.getStatus());
                    return this.orderRepository.save(o);
                }
        );

    }
}
