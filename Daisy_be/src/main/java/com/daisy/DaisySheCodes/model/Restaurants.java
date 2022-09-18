package com.daisy.DaisySheCodes.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "restaurant")
public class Restaurants extends Nodes{
    @Id
    @GeneratedValue
    private Long id;
    private String restaurant_name;
    private String address;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Orders> orders;

    @Override
    void calculateM(Nodes previousNode) {

    }
}
