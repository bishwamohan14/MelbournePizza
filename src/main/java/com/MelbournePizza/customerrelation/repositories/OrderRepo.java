package com.MelbournePizza.customerrelation.repositories;

import com.MelbournePizza.customerrelation.entities.Customer;
import com.MelbournePizza.customerrelation.entities.Order;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;

public interface OrderRepo extends JpaRepository<Order,Integer> {

    // findBy customer id

    Order findByCustomer(Customer customer);


}
