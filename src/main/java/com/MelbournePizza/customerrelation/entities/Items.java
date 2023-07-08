package com.MelbournePizza.customerrelation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "menu_list")
@NoArgsConstructor
@Data
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id",nullable = false,unique = true)
    private Integer id;

    @Column(name = "item",nullable = false)
    private String nameOfItem;

    @Column(name = "price",nullable = false)
    private int price;




}
