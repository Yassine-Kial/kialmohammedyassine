package com.example.kialmohammedyassine.type;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

import java.io.Serializable;


public enum Status implements Serializable {



    CONFIRMED,
    CANCELLED,
    PENDING

}
