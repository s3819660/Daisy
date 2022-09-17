package com.daisy.DaisySheCodes.controller;

import com.daisy.DaisySheCodes.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
}
