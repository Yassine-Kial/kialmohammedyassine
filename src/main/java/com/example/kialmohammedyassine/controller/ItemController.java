package com.example.kialmohammedyassine.controller;


import com.example.kialmohammedyassine.entity.Item;
import com.example.kialmohammedyassine.entity.Order;
import com.example.kialmohammedyassine.entity.OrderDetail;
import com.example.kialmohammedyassine.service.ItemService;
import com.example.kialmohammedyassine.service.OrderDetailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;
    private final OrderDetailService orderDetailService;


    public ItemController(ItemService itemService, OrderDetailService orderDetailService) {
        this.itemService = itemService;
        this.orderDetailService = orderDetailService;
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

    @PostMapping("/assignOrderDetailToItem/{id}")
    public void assignOrderDetailToItem(@PathVariable Long id, @RequestBody OrderDetail orderDetail) {
        Item item = this.itemService.getItemById(id);
        item.addOrderDetail(orderDetail);
        this.orderDetailService.addOrderDetail(orderDetail);
    }


}
