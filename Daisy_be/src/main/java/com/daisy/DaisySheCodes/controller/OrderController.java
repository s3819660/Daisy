package com.daisy.DaisySheCodes.controller;

import com.daisy.DaisySheCodes.model.Orders;
import com.daisy.DaisySheCodes.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    // this function will call the close radius orders
    @GetMapping("orders/getOrders")
    public ResponseEntity<List<Orders>> getOrders(){
        return ResponseEntity.ok(this.orderService.getOrders());
    }



}
