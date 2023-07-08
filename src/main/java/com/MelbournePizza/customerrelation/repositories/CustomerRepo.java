package com.MelbournePizza.customerrelation.repositories;

import com.MelbournePizza.customerrelation.entities.Customer;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    Customer findByphoneNumber(String phoneNumber);
}
