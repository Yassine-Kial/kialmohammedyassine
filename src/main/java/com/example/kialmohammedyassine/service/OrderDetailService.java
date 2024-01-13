package com.example.kialmohammedyassine.service;


import com.example.kialmohammedyassine.entity.OrderDetail;
import com.example.kialmohammedyassine.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;

    @Autowired
    public OrderDetailService(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }


    public List<OrderDetail> getAllOrderDetails() {
        return this.orderDetailRepository.findAll();
    }

    public OrderDetail getOrderDetailById(Long id) {
        return this.orderDetailRepository.findById(id).get();
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        this.orderDetailRepository.save(orderDetail);
    }

    public void deleteOrderDetail(Long id) {
        this.orderDetailRepository.deleteById(id);
    }

    public void updateOrderDetail(Long id, OrderDetail orderDetail) {
        this.orderDetailRepository.findById(id).map(o->{
            o.setId(id);
            o.setQuantity(orderDetail.getQuantity());
            o.setTaxStatus(orderDetail.getTaxStatus());
            return this.orderDetailRepository.save(o);

        });
    }
}
