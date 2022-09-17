package com.daisy.DaisySheCodes.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;

    String name;
    String address;

//    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private Collection<Order> orders;
}
