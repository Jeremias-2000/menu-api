package com.menu.document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.menu.enums.FoodType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@Document(collection = "menu")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

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


   // @NotNull(message = "tipo de comida nao pode ser nulo")


    private FoodType foodType;
}
