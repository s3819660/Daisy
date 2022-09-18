package com.daisy.DaisySheCodes.repository;

import com.daisy.DaisySheCodes.model.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Orders, Long> {
    public List<Orders> findAllByMarkCompletedIsFalseAndShipperIsNull();


}
