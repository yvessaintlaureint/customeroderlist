package com.odp297.demo.service;

import com.odp297.demo.model.OrderList;
import com.odp297.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
     
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public List<OrderList> getAllOrder(){
        return orderRepository.findAll();
    }
    public OrderList saveOrder(OrderList orderList){
        return orderRepository.save(orderList);
    }
}
