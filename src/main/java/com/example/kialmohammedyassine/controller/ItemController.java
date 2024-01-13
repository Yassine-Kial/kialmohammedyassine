package com.example.kialmohammedyassine.controller;


import com.example.kialmohammedyassine.entity.Item;
import com.example.kialmohammedyassine.entity.Order;
import com.example.kialmohammedyassine.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;


    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @GetMapping("/getAll")
    public List<Item> getAllItem() {
        return this.itemService.getAllItems();
    }


    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Long id) {
        return this.itemService.getItemById(id);
    }




    @PostMapping("/add")
    public void addItem(@RequestBody Item item) {
        this.itemService.addItem(item);
    }



    @DeleteMapping("/delete/{id}")
    public void deleteItem(@PathVariable Long id) {
        this.itemService.deleteItem(id);
    }


    @PutMapping("/update/{id}")
    public void updateItem(@PathVariable Long id, @RequestBody Item item) {
        this.itemService.updateItem(id,item);
    }


}
