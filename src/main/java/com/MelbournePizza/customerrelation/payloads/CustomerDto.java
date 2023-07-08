package com.MelbournePizza.customerrelation.payloads;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
public class CustomerDto {


    private int id;


    @NotEmpty(message = "Please Enter Name")
    @Size(min=3,message = "Minimum character should not be less than 3 characters!!!!! ")
    private String name;


//    @Pattern(regexp = "^\\d{10}$",message = "Invalid Mobile Number...Re-enter the mobile number")
//    @Digits(fraction=0, integer=10,message = "Invalid Phone Number!!!")
//    @Size(max = 10,min = 10,message = "invalid phone number!!!!")
//    @Digits(fraction=0, integer=10,message = "Invalid Phone Number!!!")




    @NotEmpty(message = "Phone Number cannot be empty")
    @Column(unique = true,nullable = false)
    @Pattern(regexp = "^\\d{10}$",message = "Invalid Mobile Number...Re-enter the mobile number")
    private String phoneNumber;

}
