package com.MelbournePizza.customerrelation.services.serviceImpl;

import com.MelbournePizza.customerrelation.entities.Customer;
import com.MelbournePizza.customerrelation.entities.Order;
import com.MelbournePizza.customerrelation.exceptions.ResourceNotFoundException;
import com.MelbournePizza.customerrelation.payloads.OrderDto;
import com.MelbournePizza.customerrelation.repositories.CustomerRepo;
import com.MelbournePizza.customerrelation.repositories.OrderRepo;
import com.MelbournePizza.customerrelation.services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class OrderImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepo customerRepo;

    // create order by customer id
    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Customer customer=this.customerRepo.findById(orderDto.getCustomerId()).orElseThrow(()->new ResourceNotFoundException("Customer","Customer Id",orderDto.getCustomerId()));
        Order order = this.modelMapper.map(orderDto, Order.class);
        order.setDate(new Date());
        order.setCustomer(customer);
        order.setRewardPoints((int) (order.getTotalAmount()/10));
        Order savedOrder = this.orderRepo.save(order);
        OrderDto savedOrderDto = this.modelMapper.map(savedOrder, OrderDto.class);
        return savedOrderDto;
    }

    // create order by customer Phone Number
    @Override
    public OrderDto createOrder(OrderDto orderDto, String phoneNumber) {
        Customer customer=this.customerRepo.findByphoneNumber(phoneNumber);
        Order order = this.modelMapper.map(orderDto, Order.class);
        order.setDate(new Date());
        order.setCustomer(customer);
        order.setRewardPoints((int) (order.getTotalAmount()/10));
        Order savedOrder = this.orderRepo.save(order);
        OrderDto savedOrderDto = this.modelMapper.map(savedOrder, OrderDto.class);
        return savedOrderDto;
    }






    @Override
    public OrderDto updateOrder(OrderDto orderDto, Integer orderId) {
        return null;
    }

    @Override
    public void deleteOrder(Integer orderId) {

    }

    @Override
    public List<Order> getAllOrders() {
        return null;
    }

    @Override
    public Order getOrderByOrderId(Integer orderId) {
        return null;
    }

    @Override
    public Order getOrderByCustomer(Integer customerId) {
        return null;
    }
}
