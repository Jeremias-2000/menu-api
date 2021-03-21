package com.menu.document;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.menu.enums.FoodType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@Document(collection = "menu")
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    @Id
    private String id;
    @Size(min = 2,max = 200)
    @NotNull(message = "Nome do cardapio nao pode ser nulo")
    private String itemName;

    @NotNull(message = "Tempo de preparacao nao pode ser nulo")
    private String preparationTime;
    @NotNull(message = "Descricao nao pode ser nulo")
    private String description;
    @NotNull(message = "preco nao pode ser nulo")
    private double price;


    @NotNull(message = "tipo de comida nao pode ser nulo")
    private FoodType foodType;
}
