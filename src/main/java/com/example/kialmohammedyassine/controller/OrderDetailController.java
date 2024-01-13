package com.example.kialmohammedyassine.controller;

import com.example.kialmohammedyassine.entity.Customer;
import com.example.kialmohammedyassine.entity.OrderDetail;
import com.example.kialmohammedyassine.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    @Autowired
    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @GetMapping("/getAll")
    public List<OrderDetail> getAllOrderDetails() {
        return this.orderDetailService.getAllOrderDetails();
    }


    @GetMapping("/{id}")
    public OrderDetail getOrderDetailById(@PathVariable Long id) {
        return this.orderDetailService.getOrderDetailById(id);
    }


    @PostMapping("/add")
    public void addOrderDetail(@RequestBody OrderDetail orderDetail
    ) {
        this.orderDetailService.addOrderDetail(orderDetail);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrderDetail(@PathVariable Long id) {
        this.orderDetailService.deleteOrderDetail(id);
    }

    @PutMapping("/update/{id}")
    public void updateOrderDetail(@PathVariable Long id, @RequestBody OrderDetail orderDetail) {
        this.orderDetailService.updateOrderDetail(id,orderDetail);
    }

}
