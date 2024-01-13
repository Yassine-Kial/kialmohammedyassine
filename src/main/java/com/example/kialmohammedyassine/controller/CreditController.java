package com.example.kialmohammedyassine.controller;


import com.example.kialmohammedyassine.entity.Credit;
import com.example.kialmohammedyassine.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credit")
public class CreditController {
    private final CreditService creditService;

    @Autowired
    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @GetMapping("/getAll")
    public List<Credit> getAllCredits() {
        return this.creditService.getAllCredits();
    }


    @GetMapping("/{id}")
    public Credit getCreditById(@PathVariable Long id) {
        return this.creditService.getCreditById(id);
    }


    @PostMapping("/add")
    public void addCredit(@RequestBody Credit credit) {
        this.creditService.addCredit(credit);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCredit(@PathVariable Long id) {
        this.creditService.deleteCredit(id);
    }

    @PutMapping("/update/{id}")
    public void updateCredit(@PathVariable Long id, @RequestBody Credit credit) {
        this.creditService.updateCredit(id,credit);
    }



}
