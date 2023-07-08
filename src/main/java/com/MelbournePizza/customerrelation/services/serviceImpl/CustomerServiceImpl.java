package com.MelbournePizza.customerrelation.services.serviceImpl;

import com.MelbournePizza.customerrelation.entities.Customer;
import com.MelbournePizza.customerrelation.exceptions.ResourceNotFoundException;
import com.MelbournePizza.customerrelation.exceptions.UserAlreadyExistException;
import com.MelbournePizza.customerrelation.payloads.CustomerDto;
import com.MelbournePizza.customerrelation.repositories.CustomerRepo;
import com.MelbournePizza.customerrelation.services.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {


    //Model
 

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomerDto createNewCustomer(CustomerDto customerDto) {
        Customer checkNumber = customerRepo.findByphoneNumber(customerDto.getPhoneNumber());
        if(checkNumber !=null){
            throw new UserAlreadyExistException(checkNumber.getPhoneNumber());
        }else {
            Customer customer = this.modelMapper.map(customerDto, Customer.class);
            Customer save = this.customerRepo.save(customer);
            CustomerDto customerDto1 = this.modelMapper.map(save,CustomerDto.class);
            return customerDto1;
        }

        }



    @Override
    public CustomerDto updateCustomerDetails(CustomerDto customerDto, Integer customerId) {
        Customer customer = this.customerRepo.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer","Customer id",customerId));
        customer.setName(customerDto.getName());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        Customer save = this.customerRepo.save(customer);
        CustomerDto customerDto1 = this.customerToDto(save);
        return customerDto1;
    }

    @Override
    public CustomerDto getCustomerById(Integer customerId) {
        Customer customer= this.customerRepo.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer","customer id",customerId));
        CustomerDto customerDto = this.customerToDto(customer);
        return customerDto;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> allCustomers = this.customerRepo.findAll();
        List<CustomerDto> customerDtos = allCustomers.stream().map(customer -> this.customerToDto(customer)).collect(Collectors.toList());
        return customerDtos;
    }

    @Override
    public void deleteCustomer(Integer customerId) {
        Customer customer=this.customerRepo.findById(customerId).orElseThrow(()->new ResourceNotFoundException("customer","customer Id",customerId));
        this.customerRepo.delete(customer);
    }
    public Customer dtoToCustomer(CustomerDto customerDto){
        Customer customer = this.modelMapper.map(customerDto,Customer.class);
//        Customer customer=new Customer();
//        customer.setId(customerDto.getId());
//        customer.setName(customerDto.getName());
//        customer.setPhoneNumber(customerDto.getPhoneNumber());
        return customer;
    }

    public CustomerDto customerToDto(Customer customer){
        CustomerDto customerDto=this.modelMapper.map(customer,CustomerDto.class);
//        CustomerDto customerDto=new CustomerDto();
//        customerDto.setId(customer.getId());
//        customerDto.setName(customer.getName());
//        customerDto.setPhoneNumber(customer.getPhoneNumber());
        return customerDto;
    }
}
