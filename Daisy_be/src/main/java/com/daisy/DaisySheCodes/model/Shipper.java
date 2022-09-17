package com.daisy.DaisySheCodes.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "shipper")
public class Shipper {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String address;

//    @OneToMany(mappedBy = "shipper", cascade = CascadeType.ALL)
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private Collection<Order> orders;
}
