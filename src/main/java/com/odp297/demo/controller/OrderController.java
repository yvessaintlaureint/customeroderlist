package com.odp297.demo.controller;

import com.odp297.demo.model.OrderList;
import com.odp297.demo.model.User;
import com.odp297.demo.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderList> getAllOrder(){
        return  orderService.getAllOrder();
    }

    @PostMapping
    public OrderList createOrder(@RequestBody OrderList orderList){
        return orderService.saveOrder(orderList);
    }
}
