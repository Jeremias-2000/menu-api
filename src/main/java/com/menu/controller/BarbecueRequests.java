package com.menu.controller;

import com.menu.document.Barbecue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface BarbecueRequests {
    @GetMapping("search findAll")
    ResponseEntity<?> findAll();
    @GetMapping("search id{id}")
    ResponseEntity<?>findBarbecueById(@PathVariable("id") Barbecue barbecueId);
    @PostMapping("save")
    ResponseEntity<?> save(@RequestBody Barbecue barbecue);
}

