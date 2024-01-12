package com.example.kialmohammedyassine.entity;


import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private float amount;


    @ManyToOne(fetch = FetchType.EAGER)
    private Order order;


    public Payment(float amount) {
        this.amount = amount;
    }
    public Payment() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
