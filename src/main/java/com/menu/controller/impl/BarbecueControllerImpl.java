package com.menu.controller.impl;

import com.menu.controller.BarbecueRequests;
import com.menu.document.Barbecue;
import com.menu.exception.ProductAlreadyRegisteredException;
import com.menu.exception.ProductNotFoundException;
import com.menu.service.impl.BarbecueServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Optional;

import static org.springframework.web.client.HttpClientErrorException.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/menu/barbecue")

public class BarbecueControllerImpl implements BarbecueRequests {
    @Autowired
    private BarbecueServiceImpl barbecueService;

    @Override
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(barbecueService.findAll());
    }

    @Override
    public ResponseEntity<?> findBarbecueById(Long barbecueId) throws ProductNotFoundException {
        return ResponseEntity.ok(barbecueService
                .findById(barbecueId));
    }

    @Override
    public ResponseEntity<?> save(Barbecue barbecue) throws ProductAlreadyRegisteredException {
        return new ResponseEntity<>(barbecueService.save(barbecue), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateBarbecueById(Long barbecueId, Barbecue barbecue) throws ProductNotFoundException {

        return ResponseEntity.ok(barbecueService.update(barbecueId, barbecue));

    }

    @Override
    public ResponseEntity<?> deleteBarbecueById(Long barbecueId) throws ProductNotFoundException {
        barbecueService.delete(barbecueId);
        return ResponseEntity.ok().build();
    }
}
