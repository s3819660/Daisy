package com.daisy.DaisySheCodes.service;

import com.daisy.DaisySheCodes.repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipperService {
    @Autowired
    ShipperRepository shipperRepository;
}
