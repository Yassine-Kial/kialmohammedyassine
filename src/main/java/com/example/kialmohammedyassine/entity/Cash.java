package com.example.kialmohammedyassine.entity;

import jakarta.persistence.Entity;

@Entity
public class Cash extends Payment{

    private float cashTendered;

    public Cash(float amount, float cashTendered) {
        super(amount);
        this.cashTendered = cashTendered;
    }

    public Cash(float cashTendered) {
        this.cashTendered = cashTendered;
    }

    public Cash() {

    }

    public void setCashTendered(float cashTendered) {
        this.cashTendered = cashTendered;
    }

    public float getCashTendered() {
        return cashTendered;
    }
}
