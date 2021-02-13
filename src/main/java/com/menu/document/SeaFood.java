package com.menu.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "seafood")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeaFood implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private long seafoodId;
    private String itemName;
    private String preparationTime;
    private String description;
    private double price;
}
