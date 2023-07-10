package com.MelbournePizza.customerrelation.services.serviceImpl;

import com.MelbournePizza.customerrelation.entities.Customer;
import com.MelbournePizza.customerrelation.exceptions.UserAlreadyExistException;
import com.MelbournePizza.customerrelation.payloads.CustomerDto;
import com.MelbournePizza.customerrelation.repositories.CustomerRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
class CustomerServiceImplTest {

    @InjectMocks
    CustomerServiceImpl customerServiceImpl;

    @Mock
    CustomerRepo repo;

    @Mock
    ModelMapper modelMapper;

    @Test
    @DisplayName("this test will pass if this is a new phone number and create the object")
    public void createNewCustomer() {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setPhoneNumber("1234567890");
        Customer customer = new Customer();
        when(repo.findByphoneNumber(customerDto.getPhoneNumber())).thenReturn(null);
        when(modelMapper.map(customerDto,Customer.class)).thenReturn(customer);
        when(repo.save(customer)).thenReturn(customer);
        when(modelMapper.map(customer,CustomerDto.class)).thenReturn(customerDto);

        CustomerDto result = customerServiceImpl.createNewCustomer(customerDto);

        Assertions.assertEquals(customerDto,result);


    }

    @Test
    @DisplayName("if user already exists,throw exception")
    public void testCreateNewCustomer_DuplicateNumber_ThrowsException() {
        // Arrange
        CustomerDto customerDto = new CustomerDto();
        customerDto.setPhoneNumber("1234567890");
        Customer existingCustomer = new Customer();
        when(repo.findByphoneNumber(customerDto.getPhoneNumber())).thenReturn(existingCustomer);

        // Act and Assert
        Assertions.assertThrows(UserAlreadyExistException.class, () -> {
            customerServiceImpl.createNewCustomer(customerDto);
        });

    }


}
/*

        when(customerRepo.findByphoneNumber(customerDto.getPhoneNumber())).thenReturn(null);
        when(modelMapper.map(customerDto, Customer.class)).thenReturn(customer);
        when(customerRepo.save(customer)).thenReturn(customer);
        when(modelMapper.map(customer, CustomerDto.class)).thenReturn(customerDto);

        // Act
        CustomerDto result = customerService.createNewCustomer(customerDto);

        // Assert
        Assertions.assertEquals(customerDto, result);
        verify(customerRepo, times(1)).findByphoneNumber(customerDto.getPhoneNumber());
        verify(customerRepo, times(1)).save(customer);
    }

    @Test
    public void testCreateNewCustomer_DuplicateNumber_ThrowsException() {
        // Arrange
        CustomerDto customerDto = new CustomerDto();
        customerDto.setPhoneNumber("1234567890");
        Customer existingCustomer = new Customer();
        when(customerRepo.findByphoneNumber(customerDto.getPhoneNumber())).thenReturn(existingCustomer);

        // Act and Assert
        Assertions.assertThrows(UserAlreadyExistException.class, () -> {
            customerService.createNewCustomer(customerDto);
        });
        verify(customerRepo, times(1)).findByphoneNumber(customerDto.getPhoneNumber());
        verify(customerRepo, never()).save(any(Customer.class));
    }
}


 */





/*


 @Test
//    void updateCustomerDetails() {
//    }
//
//    @Test
//    void getCustomerById() {
//    }
//
//    @Test
//    void getAllCustomers() {
//    }
//
//    @Test
//    void deleteCustomer() {
//    }

 */