package com.MelbournePizza.customerrelation.services;

import com.MelbournePizza.customerrelation.entities.Order;
import com.MelbournePizza.customerrelation.payloads.OrderDto;

import java.util.List;

public interface OrderService {

    //create order

    OrderDto createOrder(OrderDto orderDto);

    // create order by giving input as phone  number as string
    OrderDto createOrder(OrderDto orderDto,String phoneNumber);

    //update

    OrderDto updateOrder(OrderDto orderDto,Integer orderId);

    //delete

    void deleteOrder(Integer orderId);

    //get all

    List<Order> getAllOrders();

    Order getOrderByOrderId(Integer orderId);

    // Order by customer id

    Order getOrderByCustomer(Integer customerId);



}
