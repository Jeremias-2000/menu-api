package com.menu.service.impl;

import com.menu.document.Drink;
import com.menu.repository.DrinkRepository;
import com.menu.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkServiceImpl implements DrinkService<Drink> {
    @Autowired
    private DrinkRepository drinkRepository;

    @Override
    public List<Drink> findAll() {
        return drinkRepository.findAll();
    }

    @Override
    public Drink findById(Long drinkId) {
        return drinkRepository.findById(drinkId).orElseThrow(()
                -> new RuntimeException());
    }

    @Override
    public Drink findByName(String name) {
        return null;
    }

    @Override
    public Drink save(Drink newDrink) {
        return drinkRepository.save(newDrink);
    }

    @Override
    public Drink update(Long drinkId, Drink updateDrink) {
        Drink search = drinkRepository.findById(drinkId).orElseThrow(() -> new RuntimeException());
        search.setDrinkId(updateDrink.getDrinkId());
        search.setItemName(updateDrink.getItemName());
        search.setPreparationTime(updateDrink.getPreparationTime());
        search.setDescription(updateDrink.getDescription());
        search.setPrice(updateDrink.getPrice());
        return search;
    }

    @Override
    public void delete(Long drinkId) {
        Drink search = drinkRepository.findById(drinkId).orElseThrow(() -> new RuntimeException());
        drinkRepository.delete(search);

    }
}
