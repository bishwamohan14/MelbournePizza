package com.MelbournePizza.customerrelation.payloads;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ItemsDto {

    private Integer id;
    @NotEmpty(message = "Name of Items cannot not be empty!!!")
    @Size(min=3,message = "Minimum character should not be less than 3 characters!!!!! ")
    private String nameOfItem;

    @NotNull
    private Integer price;
}
