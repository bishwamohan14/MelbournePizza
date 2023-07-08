package com.MelbournePizza.customerrelation.services;

import com.MelbournePizza.customerrelation.entities.Customer;
import com.MelbournePizza.customerrelation.payloads.CustomerDto;

import java.util.List;

public interface CustomerService {

    //Create Customer crud
    CustomerDto createNewCustomer(CustomerDto customerDto);
    CustomerDto updateCustomerDetails(CustomerDto customerDto,Integer customerId);
    CustomerDto getCustomerById(Integer customerId);

    List<CustomerDto> getAllCustomers();
    void deleteCustomer (Integer customerId);



}
