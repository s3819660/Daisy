package com.daisy.DaisySheCodes.controller;

import com.daisy.DaisySheCodes.model.Orders;
import com.daisy.DaisySheCodes.response.OrderResponse;
import com.daisy.DaisySheCodes.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    // this function will call the close radius orders
    @GetMapping("orders/getOrders")
    public ResponseEntity<List<OrderResponse>> getOrders() throws Exception {
        List<OrderResponse> orderResponses= new ArrayList<>();
        List<Orders> orderList = this.orderService.getOrders();
        if(orderList != null){
            for (Orders orders : this.orderService.getOrders()){
                orderResponses.add(new OrderResponse(orders.getId(), orders.getCustomer().getName(), orders.getRestaurant().getRestaurant_name(), orders.getRestaurant().getAddress(),orders.getCustomer().getAddress(),orders.getAmount(), orders.getTotal(), orders.getDate()));
            }
        }
        return ResponseEntity.ok(orderResponses);
    }
}
