package com.daisy.DaisySheCodes.service;

import com.daisy.DaisySheCodes.model.Orders;
import com.daisy.DaisySheCodes.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<Orders> getOrders(){
        List<Orders> orders = orderRepository.findAllByMarkCompletedIsFalseAndShipperIsNull();

        // if the result list is equal to 0 , meaning the shipper does not receive any order.
        if(orders.size() == 0 ){
            return orders;
        }
        else{
            // else return the recommendation system
            return null;
        }
    }

}
