package com.menu.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "drinks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drink implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private long drinkId;
    private String itemName;
    private String preparationTime;
    private String description;
    private double price;
}
