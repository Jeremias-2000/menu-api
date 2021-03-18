package com.menu.dto;

import com.menu.document.Barbecue;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BarbecueDTO {
    private String id;
    private String itemName;

    private String preparationTime;

    private String description;

    private double price;


}
