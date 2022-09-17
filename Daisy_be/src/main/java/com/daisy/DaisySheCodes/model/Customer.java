package com.daisy.DaisySheCodes.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "Cutomer_name")
    private String name;

    @Column(name = "Cutomer_address")
    private String address;

//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private Collection<Order> orders;
}
