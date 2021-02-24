package com.menu.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Document(collection = "barbecue")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Barbecue implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private long barbecueId;
    @NotNull(message = "Nome do cardapio nao pode ser nulo")
    private String itemName;
    @NotNull(message = "Tempo de preparacao nao pode ser nulo")
    private String preparationTime;
    @NotNull(message = "Descricao nao pode ser nulo")
    private String description;
    @NotNull(message = "")
    private double price;
}
