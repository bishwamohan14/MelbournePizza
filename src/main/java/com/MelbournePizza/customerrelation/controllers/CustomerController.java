package com.MelbournePizza.customerrelation.controllers;

import com.MelbournePizza.customerrelation.payloads.ApiResponse;
import com.MelbournePizza.customerrelation.payloads.CustomerDto;
import com.MelbournePizza.customerrelation.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {


    @Autowired
    private CustomerService customerService;
    // post-create new customer

    @PostMapping("/add")
    public ResponseEntity<CustomerDto> createNewCustomer(@Valid @RequestBody CustomerDto customerDto){
        CustomerDto newCustomer = this.customerService.createNewCustomer(customerDto);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    // put update

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDto> updateCustomerDetails(@Valid @RequestBody CustomerDto customerDto,@PathVariable Integer customerId){
        CustomerDto updatedCustomer = this.customerService.updateCustomerDetails(customerDto, customerId);
        return ResponseEntity.ok(updatedCustomer);
    }

    //delete
    @DeleteMapping("/{customerId}")
    public ResponseEntity<ApiResponse> deleteCustomer(@PathVariable Integer customerId){
        this.customerService.deleteCustomer(customerId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Deleted successfully",true),HttpStatus.OK);
    }

    //get user
    @GetMapping("/")
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        return ResponseEntity.ok(this.customerService.getAllCustomers());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getAllCustomers(@PathVariable Integer customerId){
        return ResponseEntity.ok(this.customerService.getCustomerById(customerId));
    }

}
