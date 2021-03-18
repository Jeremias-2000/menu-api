package com.menu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(Long barbecueId) {
        super(String.format("id inexistente : ",barbecueId));

    }

    public ProductNotFoundException(String name) {
        super(String.format("nome inexistente : ",name));
    }
}
