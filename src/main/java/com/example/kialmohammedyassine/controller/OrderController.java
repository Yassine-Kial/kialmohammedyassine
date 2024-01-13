package com.example.kialmohammedyassine.controller;


import com.example.kialmohammedyassine.entity.Cash;
import com.example.kialmohammedyassine.entity.Customer;
import com.example.kialmohammedyassine.entity.Order;
import com.example.kialmohammedyassine.entity.OrderDetail;
import com.example.kialmohammedyassine.service.CashService;
import com.example.kialmohammedyassine.service.OrderDetailService;
import com.example.kialmohammedyassine.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final OrderDetailService orderDetailService;
    private final CashService cashService;

    @Autowired
    public OrderController(OrderService orderService, OrderDetailService orderDetailService, CashService cashService) {
        this.orderService = orderService;
        this.orderDetailService = orderDetailService;
        this.cashService = cashService;
    }



    @GetMapping("/getAll")
    public List<Order> getAllOrders() {
        return this.orderService.getAllOrders();
    }


    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return this.orderService.getOrderById(id);
    }




    @PostMapping("/add")
    public void addOrder(@RequestBody Order order) {
        this.orderService.addOrder(order);
    }



    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable Long id) {
        this.orderService.deleteOrder(id);
    }


    @PutMapping("/update/{id}")
    public void updateOrder(@PathVariable Long id, @RequestBody Order order) {
        this.orderService.updateCustomer(id,order);
    }



    @PostMapping("/assignOrderDetailToOrder/{id}/{orderDetailId}")
    public void assignOrderDetailToOrder(@PathVariable Long id, @PathVariable Long orderDetailId) {
        Order order = this.orderService.getOrderById(id);
        OrderDetail orderDetail = this.orderDetailService.getOrderDetailById(orderDetailId);
        order.addOrderDetail(orderDetail);
        this.orderDetailService.updateOrderDetail(orderDetail.getId(),orderDetail);

    }

    @PostMapping("/assignCashToOrder/{id}/{cashId}")
    public void assignPaymentToOrder(@PathVariable Long id, @PathVariable Long cashId) {
        Order order = this.orderService.getOrderById(id);
        Cash cash = this.cashService.getCashById(cashId);
        order.addPayment(cash);
        this.cashService.updateCash(cash.getId(),cash);
    }









}
