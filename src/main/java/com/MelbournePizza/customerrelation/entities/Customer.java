package com.MelbournePizza.customerrelation.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers_list")
@NoArgsConstructor
@Getter
@Setter
public class Customer {

    @Id
    @Column(nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "user_name",nullable = false)
    private String name;

    @Column(name = "contact",nullable = false,unique = true)
    private String phoneNumber;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Order> orders=new ArrayList<>();

}

