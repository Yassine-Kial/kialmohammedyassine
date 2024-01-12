package com.example.kialmohammedyassine.repository;

import com.example.kialmohammedyassine.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
