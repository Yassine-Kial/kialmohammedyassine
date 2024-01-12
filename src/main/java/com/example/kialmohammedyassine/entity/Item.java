package com.example.kialmohammedyassine.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int shippingWeight;
    private String description;


    @OneToMany(mappedBy = "item",fetch = FetchType.EAGER)
    private List<OrderDetail> orderDetails = new ArrayList<>();


    public Item(int shippingWeight, String description) {
        this.shippingWeight = shippingWeight;
        this.description = description;
    }

    public Item() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getShippingWeight() {
        return shippingWeight;
    }

    public void setShippingWeight(int shippingWeight) {
        this.shippingWeight = shippingWeight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetail.setItem(this);
        orderDetails.add(orderDetail);
    }

    public List<String> getTax() {
        List<String> listTaxes = new ArrayList<>();
        for (OrderDetail orderDetail : orderDetails) {
            listTaxes.add(orderDetail.getTaxStatus());
        }

        return listTaxes;
    }

}
