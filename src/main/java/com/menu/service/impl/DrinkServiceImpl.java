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
        return null;
    }

    @Override
    public Drink findById(Long drinkId) {
        return null;
    }

    @Override
    public Drink findByName(String name) {
        return null;
    }

    @Override
    public Drink save(Drink newDrink) {
        return null;
    }

    @Override
    public Drink update(Long drinkId, Drink updateDrink) {
        return null;
    }
}
