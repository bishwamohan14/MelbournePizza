package com.MelbournePizza.customerrelation.controllers;

import com.MelbournePizza.customerrelation.payloads.OrderDto;
import com.MelbournePizza.customerrelation.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;




    //  create order by customer ID

    @PostMapping("/newOrder")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto){

        OrderDto order = this.orderService.createOrder(orderDto);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    // create customer by customer phoneNumber


    @PostMapping("/customer/{phoneNumber}/order")
    public ResponseEntity<OrderDto> createOrderByPhoneNumber(@RequestBody OrderDto orderDto, @PathVariable String phoneNumber){

        OrderDto order = this.orderService.createOrder(orderDto, phoneNumber);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }



}
