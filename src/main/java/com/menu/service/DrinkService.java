package com.menu.service;

import java.util.List;

public interface DrinkService<D> {
    List<D> findAll();
    D findById(Long  drinkId);
    D findByName(String name);
    D save(D newDrink);
    D update(Long drinkId ,D updateDrink);
    void delete(Long drinkId);
}
