package com.menu.controller;

import com.menu.document.Barbecue;

import com.menu.dto.BarbecueDTO;
import com.menu.exception.ProductAlreadyRegisteredException;
import com.menu.exception.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


public interface BarbecueRequests {
    @GetMapping("/search/findAll")
    ResponseEntity<?> findAll();
    @GetMapping("/search/id/{id}")
    ResponseEntity<?>findBarbecueById(@PathVariable("id") String barbecueId) throws ProductNotFoundException;
    @PostMapping("/save")
    ResponseEntity<?> save(@RequestBody @Valid BarbecueDTO barbecueDTO) throws ProductAlreadyRegisteredException;

    @PutMapping("/update/id/{id}")
    ResponseEntity<?> updateBarbecueById(@PathVariable("id") String barbecueId
            ,@RequestBody @Valid BarbecueDTO barbecue) throws ProductNotFoundException;
    @DeleteMapping("/delete/id/{id}")
    ResponseEntity<?> deleteBarbecueById(@PathVariable("id") String barbecueId) throws ProductNotFoundException;;

}

