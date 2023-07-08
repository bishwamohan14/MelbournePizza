package com.MelbournePizza.customerrelation.payloads;


import com.MelbournePizza.customerrelation.entities.Customer;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class OrderDto {
    private Integer orderId;

    private Date date;

    private Integer customerId;

    private Integer totalAmount;

    private Integer rewardPoints;

}
