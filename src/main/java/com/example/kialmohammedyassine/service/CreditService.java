package com.example.kialmohammedyassine.service;

import com.example.kialmohammedyassine.entity.Credit;
import com.example.kialmohammedyassine.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditService {
    private final CreditRepository creditRepository;


    @Autowired
    public CreditService(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    public List<Credit> getAllCredits() {
        return this.creditRepository.findAll();
    }

    public Credit getCreditById(Long id) {
        return this.creditRepository.findById(id).get();
    }

    public void addCredit(Credit credit) {
        this.creditRepository.save(credit);
    }

    public void deleteCredit(Long id) {
        this.creditRepository.deleteById(id);
    }

    public void updateCredit(Long id, Credit credit) {
        this.creditRepository.findById(id).map(c -> {
            c.setId(id);
            c.setNumber(credit.getNumber());
            c.setType(credit.getType());
            c.setNumber(credit.getNumber());
            c.setAmount(credit.getAmount());
            return this.creditRepository.save(c);
        });
    }
}
