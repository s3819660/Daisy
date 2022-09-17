package com.daisy.DaisySheCodes.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    private Long total;
    private Long amount;
    private String date;

//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "restaurant_id")
//    private Restaurant restaurant;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "customer_id")
//    private Customer customer;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "shipper_id")
//    private Shipper shipper;

}
