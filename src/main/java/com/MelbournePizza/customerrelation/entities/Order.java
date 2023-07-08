package com.MelbournePizza.customerrelation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "order_list")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id",nullable = false,unique = true)
    private Integer orderId;

    private Date date;

    @ManyToOne
    @JsonIgnore
    private Customer customer;

    private Integer totalAmount;

    private Integer rewardPoints;



}
