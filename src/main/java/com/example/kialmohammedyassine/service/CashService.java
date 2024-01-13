package com.example.kialmohammedyassine.service;

import com.example.kialmohammedyassine.entity.Cash;
import com.example.kialmohammedyassine.repository.CashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashService {
    private final CashRepository cashRepository;



    @Autowired
    public CashService(CashRepository cashRepository) {
        this.cashRepository = cashRepository;
    }


    public List<Cash> getAllCashs() {
        return this.cashRepository.findAll();
    }

    public Cash getCashById(Long id) {
        return this.cashRepository.findById(id).get();
    }

    public void addCash(Cash cash) {
        this.cashRepository.save(cash);
    }

    public void deleteCash(Long id) {
        this.cashRepository.deleteById(id);
    }

    public void updateCash(Long id, Cash cash) {
        this.cashRepository.findById(id).map(c -> {
            c.setId(id);
            c.setCashTendered(cash.getCashTendered());
            c.setAmount(c.getAmount());
            return this.cashRepository.save(c);
        });
    }
}
