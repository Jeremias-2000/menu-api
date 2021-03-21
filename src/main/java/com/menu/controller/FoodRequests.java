package com.menu.controller;

import com.menu.dto.FoodDTO;
import com.menu.exception.ProductAlreadyRegisteredException;
import com.menu.exception.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public interface FoodRequests {
    @GetMapping("/search/findAll")
    ResponseEntity<?> findAll();
    @GetMapping("/search/id/{id}")
    ResponseEntity<?>findBarbecueById(@PathVariable("id") String id) throws ProductNotFoundException;

    @GetMapping("/search/name/{name}")
    ResponseEntity<?>findBarbecueByName(@PathVariable("name") String name) throws ProductNotFoundException;

    @PostMapping("/save")
    ResponseEntity<?> save(@RequestBody @Valid FoodDTO foodDTO) throws ProductAlreadyRegisteredException;

    @PutMapping("/update/id/{id}")
    ResponseEntity<?> updateBarbecueById(@PathVariable("id") String id
            ,@RequestBody @Valid FoodDTO foodDTO) throws ProductNotFoundException;
    @DeleteMapping("/delete/id/{id}")
    ResponseEntity<?> deleteBarbecueById(@PathVariable("id") String id) throws ProductNotFoundException;;
}
