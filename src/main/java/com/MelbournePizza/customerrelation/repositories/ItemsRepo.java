package com.MelbournePizza.customerrelation.repositories;

import com.MelbournePizza.customerrelation.entities.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepo extends JpaRepository<Items,Integer> {
}
