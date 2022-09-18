package com.daisy.DaisySheCodes.controller;

import com.daisy.DaisySheCodes.service.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShipperController {
    @Autowired
    ShipperService shipperService;
}
