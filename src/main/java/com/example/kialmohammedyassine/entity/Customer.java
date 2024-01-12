package com.example.kialmohammedyassine.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;


    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
    private List<Order> orders = new ArrayList<>();

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public Customer() {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addOrder(Order order) {
        order.setCustomer(this);
        orders.add(order);
    }
}
