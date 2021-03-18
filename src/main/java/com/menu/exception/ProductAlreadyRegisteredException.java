package com.menu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProductAlreadyRegisteredException extends Exception {
    public ProductAlreadyRegisteredException(String itemName) {
        super(String.format("O produto ja esta cadastrado ",itemName));
    }
}
