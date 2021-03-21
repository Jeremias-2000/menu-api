package com.menu.dto;

import com.menu.enums.FoodType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodDTO {
    private String id;
    @NotNull
    @NotEmpty
    @Size(min = 2,max = 200)
    private String itemName;

    @NotNull
    @NotEmpty
    @Size(min = 10,max = 40)
    private String preparationTime;

    @NotNull
    @NotEmpty
    @Size(min = 15,max = 250)
    private String description;
    @NotNull
    @NotEmpty
    private double price;
    @NotNull
    @NotEmpty
    private FoodType foodType;
}
