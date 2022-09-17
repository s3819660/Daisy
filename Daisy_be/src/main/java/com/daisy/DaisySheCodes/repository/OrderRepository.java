package com.daisy.DaisySheCodes.repository;

import com.daisy.DaisySheCodes.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
