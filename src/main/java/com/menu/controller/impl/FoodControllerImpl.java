package com.menu.controller.impl;

import com.menu.controller.FoodRequests;
import com.menu.dto.FoodDTO;
import com.menu.exception.ProductAlreadyRegisteredException;
import com.menu.exception.ProductNotFoundException;
import com.menu.service.impl.FoodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/menu")
public class FoodControllerImpl implements FoodRequests {
    @Autowired
    private FoodServiceImpl service;

    @Override
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public ResponseEntity<?> findBarbecueById(String id) throws ProductNotFoundException {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<?> findBarbecueByName(String name) throws ProductNotFoundException {
        return ResponseEntity.ok(service.findByName(name));
    }

    @Override
    public ResponseEntity<?> save(@Valid FoodDTO foodDTO) throws ProductAlreadyRegisteredException {
        return new ResponseEntity<>(service.saveFood(foodDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateBarbecueById(String id, @Valid FoodDTO foodDTO) throws ProductNotFoundException {
        return ResponseEntity.ok(service.update(id, foodDTO)) ;
    }

    @Override
    public ResponseEntity<?> deleteBarbecueById(String id) throws ProductNotFoundException {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
