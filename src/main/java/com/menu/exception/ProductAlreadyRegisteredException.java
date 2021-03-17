package com.menu.exception;

public class ProductAlreadyRegisteredException extends Throwable {
    public ProductAlreadyRegisteredException(String itemName) {
        super(String.format("O produto ja esta cadastrado ",itemName));
    }
}
