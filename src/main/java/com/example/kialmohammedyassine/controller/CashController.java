package com.example.kialmohammedyassine.controller;


import com.example.kialmohammedyassine.entity.Cash;
import com.example.kialmohammedyassine.entity.Customer;
import com.example.kialmohammedyassine.service.CashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cash")
public class CashController {

    private final CashService cashService;

    @Autowired
    public CashController(CashService cashService) {
        this.cashService = cashService;
    }

    @GetMapping("/getAll")
    public List<Cash> getAllCashs() {
        return this.cashService.getAllCashs();
    }


    @GetMapping("/{id}")
    public Cash getCashById(@PathVariable Long id) {
        return this.cashService.getCashById(id);
    }


    @PostMapping("/add")
    public void addCash(@RequestBody Cash cash) {
        this.cashService.addCash(cash);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCash(@PathVariable Long id) {
        this.cashService.deleteCash(id);
    }

    @PutMapping("/update/{id}")
    public void updateCash(@PathVariable Long id, @RequestBody Cash cash) {
        this.cashService.updateCash(id,cash);
    }

}
