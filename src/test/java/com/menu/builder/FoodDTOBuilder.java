package com.menu.builder;

import com.menu.dto.FoodDTO;
import com.menu.enums.FoodType;
import lombok.Builder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
public class FoodDTOBuilder {

    @Builder.Default
    private String id = "xyz";

    @Builder.Default
    private String itemName = "caviar";

    @Builder.Default
    private String preparationTime = "20 minutes";

    @Builder.Default
    private String description = "seafood";

    @Builder.Default
    private double price = 1000.0;

    @Builder.Default
    private FoodType foodType = FoodType.SEAFOOD;

    public FoodDTO toFoodDTO(){
        return new FoodDTO(id,
        itemName,
        preparationTime,
        description,
        price,
        foodType);
    }
}
