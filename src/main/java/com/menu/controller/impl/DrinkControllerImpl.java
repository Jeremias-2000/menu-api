package com.menu.controller.impl;

import com.menu.controller.DrinkRequests;
import com.menu.document.Drink;
import com.menu.service.impl.DrinkServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import static org.springframework.web.client.HttpClientErrorException.*;

@RestController
@RequestMapping("/api/v1/menu/drinks")
@Slf4j
public class DrinkControllerImpl implements DrinkRequests {
    @Autowired
    private DrinkServiceImpl drinkService;

    @Override
    public ResponseEntity<?> findDrinks() {
        return ResponseEntity.ok(drinkService.findAll());
    }

    @Override
    public ResponseEntity<?> findDrinkById(Long drinkId) {
        try {
            return ResponseEntity.ok(drinkService.findById(drinkId));
        }catch (NotFound notFound){
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<?> save(Drink drink) {
        return new ResponseEntity<>(drinkService.save(drink), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateDrinkById(Long drinkId, Drink drink) {
        return ResponseEntity.ok(drinkService.update(drinkId, drink));
    }

    @Override
    public ResponseEntity<?> deleteDrinkById(Long drinkId) {
        drinkService.delete(drinkId);
        return ResponseEntity.ok().build();
    }
}
