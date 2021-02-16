package com.menu.controller;


import com.menu.document.Drink;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface DrinkRequests {

    @GetMapping("/search/findAll")
    ResponseEntity<?> findDrinks();
    @GetMapping("/search/id/{id}")
    ResponseEntity<?>findDrinkById(@PathVariable("id") Long drinkId);
    @PostMapping("/save")
    ResponseEntity<?> save(@RequestBody Drink drink);

    @PutMapping("/update/id/{id}")
    ResponseEntity<?> updateDrinkById(@PathVariable("id") Long drinkId
            ,@RequestBody Drink drink);
    @DeleteMapping("/delete/id/{id}")
    ResponseEntity<?> deleteDrinkById(@PathVariable("id") Long drinkId);;


}
