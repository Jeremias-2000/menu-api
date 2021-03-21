package com.menu.service;

import com.menu.document.Food;
import com.menu.dto.FoodDTO;
import com.menu.exception.ProductAlreadyRegisteredException;
import com.menu.exception.ProductNotFoundException;

import java.util.List;

public interface FoodService <T>{

    List<Food> findAll();
    Food findById(String id) throws ProductNotFoundException;
    Food findByName(String itemName) throws ProductNotFoundException;
    Food saveFood(T t) throws ProductAlreadyRegisteredException;
    Food update(String id,T t) throws ProductNotFoundException;
    void delete(String id) throws ProductNotFoundException;
    void verifyFoodAlreadyRegistered(String name) throws ProductAlreadyRegisteredException;
    Food convertDocumentToDTO(FoodDTO foodDTO);
}
