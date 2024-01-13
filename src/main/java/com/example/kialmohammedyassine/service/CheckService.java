package com.example.kialmohammedyassine.service;

import com.example.kialmohammedyassine.entity.Check;
import com.example.kialmohammedyassine.repository.CheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckService {

    private final CheckRepository checkRepository;

    @Autowired
    public CheckService(CheckRepository checkRepository) {
        this.checkRepository = checkRepository;
    }


    public List<Check> getAllChecks() {
        return this.checkRepository.findAll();
    }

    public Check getCheckById(Long id) {
        return this.checkRepository.findById(id).get();
    }

    public void addCheck(Check check) {
        this.checkRepository.save(check);
    }

    public void deleteCheck(Long id) {
        this.checkRepository.deleteById(id);
    }

    public void updateCheck(Long id, Check check) {
        this.checkRepository.findById(id).map(c -> {
            c.setId(id);
            c.setName(check.getName());
            c.setBankID(check.getBankID());
            c.setAmount(check.getAmount());
            return this.checkRepository.save(c);
        });
    }
}
