package com.example.kialmohammedyassine.controller;

import com.example.kialmohammedyassine.entity.Cash;
import com.example.kialmohammedyassine.entity.Check;
import com.example.kialmohammedyassine.service.CheckService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/check")
public class CheckController {
    private final CheckService checkService;

    public CheckController(CheckService checkService) {
        this.checkService = checkService;
    }

    @GetMapping("/getAll")
    public List<Check> getAllChecks() {
        return this.checkService.getAllChecks();
    }


    @GetMapping("/{id}")
    public Check getCheckById(@PathVariable Long id) {
        return this.checkService.getCheckById(id);
    }


    @PostMapping("/add")
    public void addCheck(@RequestBody Check check) {
        this.checkService.addCheck(check);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCheck(@PathVariable Long id) {
        this.checkService.deleteCheck(id);
    }

    @PutMapping("/update/{id}")
    public void updateCheck(@PathVariable Long id, @RequestBody Check check) {
        this.checkService.updateCheck(id,check);
    }
}
