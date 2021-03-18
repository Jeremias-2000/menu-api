package com.menu.document;


import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Document(collection = "barbecue")
@Data
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Barbecue implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private long barbecueId;
    @Size(min = 2,max = 200)
    @NotNull(message = "Nome do cardapio nao pode ser nulo")
    private String itemName;
    
    @NotNull(message = "Tempo de preparacao nao pode ser nulo")
    private String preparationTime;
    @NotNull(message = "Descricao nao pode ser nulo")
    private String description;
    @NotNull(message = "preco nao pode ser nulo")
    private double price;
}
