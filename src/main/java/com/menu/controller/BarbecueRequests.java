package com.menu.controller;

import com.menu.document.Barbecue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public interface BarbecueRequests {
    @GetMapping("/search/findAll")
    ResponseEntity<?> findAll();
    @GetMapping("/search/id/{id}")
    ResponseEntity<?>findBarbecueById(@PathVariable("id") Long barbecueId);
    @PostMapping("/save")
    ResponseEntity<?> save(@RequestBody Optional<Barbecue> barbecue);

    @PutMapping("/update/id/{id}")
    ResponseEntity<?> updateBarbecueById(@PathVariable("id") Long barbecueId
            ,@RequestBody Barbecue barbecue);
    @DeleteMapping("/delete/id/{id}")
    ResponseEntity<?> deleteBarbecueById(@PathVariable("id") Long barbecueId);;

}

