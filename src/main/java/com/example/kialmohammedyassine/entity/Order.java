package com.example.kialmohammedyassine.entity;


import com.example.kialmohammedyassine.type.Status;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orderTable")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;



    @Enumerated
    private Status status = Status.CONFIRMED;


    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;


    @OneToMany( mappedBy = "order",fetch = FetchType.EAGER)
    private List<Payment> payments = new ArrayList<>();


    @OneToMany(mappedBy = "order",fetch = FetchType.EAGER)
    private List<OrderDetail> orderDetails= new ArrayList<>();



    public Order(Date date, Status status) {
        this.date = date;
        this.status = status;
    }

    public Order(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetail.setOrder(this);
        orderDetails.add(orderDetail);
    }

    public void addPayment(Payment payment) {
        payment.setOrder(this);
        payments.add(payment);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}

